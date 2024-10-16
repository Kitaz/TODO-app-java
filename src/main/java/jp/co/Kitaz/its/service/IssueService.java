package jp.co.Kitaz.its.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.Kitaz.its.model.domain.IssueEntity;
import jp.co.Kitaz.its.model.mapper.IssueRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IssueService {
	
	private final IssueRepository issueRepository;
	
	public List<IssueEntity> findAll(){
		return	issueRepository.findAll();
	}
	
	@Transactional
	public void create(String summary, String description) {
		issueRepository.insert(summary,description);
		
	}
	
	public IssueEntity findById(long issueId) {
		return issueRepository.findById(issueId);
	}
	
	public int deleteId(long issueId) {
		return issueRepository.deleteId(issueId);
	}
}
