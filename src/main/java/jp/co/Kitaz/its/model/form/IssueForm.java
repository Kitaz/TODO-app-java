package jp.co.Kitaz.its.model.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class IssueForm {
	
	@NotBlank(message="空白です")
	@Size(max=255,message="文字数が規定の255文字を超えています。")
	private String summary;
	
	@NotBlank(message="空白です")
	@Size(max=255,message="文字数が規定の255文字を超えています。")
	private String description;

}
