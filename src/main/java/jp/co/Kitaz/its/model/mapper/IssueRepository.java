package jp.co.Kitaz.its.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.Kitaz.its.model.domain.IssueEntity;

@Mapper
public interface IssueRepository {
	
	@Select("select * from issues")
	List<IssueEntity> findAll();
	
	@Insert("insert into issues (summary,description) values (#{summary},#{description})")
	void insert(String summary,String description);
	
	@Select("select * from issues where id = #{issueId}")
	IssueEntity findById(long issueId);
	
	@Delete("delete from issues where id = #{issueId}")
	int deleteId(long issueId);
}
