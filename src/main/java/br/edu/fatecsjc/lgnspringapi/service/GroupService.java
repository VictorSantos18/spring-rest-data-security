package br.edu.fatecsjc.lgnspringapi.service;

import br.edu.fatecsjc.lgnspringapi.converter.GroupConverter;
import br.edu.fatecsjc.lgnspringapi.dto.GroupDTO;
import br.edu.fatecsjc.lgnspringapi.entity.Group;
import br.edu.fatecsjc.lgnspringapi.entity.Member;
import br.edu.fatecsjc.lgnspringapi.repository.GroupRepository;
import br.edu.fatecsjc.lgnspringapi.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupConverter groupConverter;

    public GroupService(GroupRepository groupRepository,
            MemberRepository memberRepository,
            GroupConverter groupConverter) {
        this.groupRepository = groupRepository;
        this.groupConverter = groupConverter;
    }

    public List<GroupDTO> getAll() {
        return groupConverter.convertToDto(groupRepository.findAll());
    }

    public GroupDTO findById(Long id) {
        Group group = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id " + id));
        return groupConverter.convertToDto(group);
    }

    @Transactional
    public GroupDTO save(Long id, GroupDTO dto) {
        Group entity = groupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Group not found with id " + id));

        entity.setName(dto.getName());

        entity.getMembers().clear();

        dto.getMembers().forEach(memberDTO -> {
            Member member = Member.builder()
                    .id(memberDTO.getId()) // 
                    .name(memberDTO.getName())
                    .age(memberDTO.getAge())
                    .group(entity)
                    .build();
            entity.getMembers().add(member);
        });

        Group savedGroup = groupRepository.save(entity);
        return groupConverter.convertToDto(savedGroup);
    }
    
    public GroupDTO save(GroupDTO dto) {
        Group groupToSaved = groupConverter.convertToEntity(dto);
        Group groupReturned = groupRepository.save(groupToSaved);
        return groupConverter.convertToDto(groupReturned);
    }

    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}
