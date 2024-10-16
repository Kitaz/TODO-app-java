package jp.co.Kitaz.its.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.Kitaz.its.model.form.IssueForm;
import jp.co.Kitaz.its.service.IssueService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IssueController {
	
	private final IssueService issueService;
	
	//トップページに飛ぶ
	@RequestMapping("/")
	public String index() {
		return "/index";
	}
	
	//タスク一覧画面に飛ぶ
	@RequestMapping("/issues")
	public String showList(Model model) {
		model.addAttribute("issueList",issueService.findAll());
		return "issues/list";
	}
	
	//タスク作成画面に飛ぶ
	@GetMapping("/creationForm")
	public String showCreationForm(@ModelAttribute IssueForm form) {
		return "issues/creationForm";
	}
	
	//Post /issues
	//タスクを作成する
	@PostMapping
	public String create(@Validated IssueForm form,BindingResult bindingResult,Model model) {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(error -> {
			System.out.println(error.getDefaultMessage());
			});
			return showCreationForm(form);
		}
		
		issueService.create(form.getSummary(),form.getDescription());
		return "redirect:/issues";
	}
	
	//GET localhost:8080/issues/1
	//issuesの詳細画面を開く
	@GetMapping("issues/{issueId}")
	public String  showDetail(@PathVariable("issueId") long issueId,Model model) {
		model.addAttribute("issue",issueService.findById(issueId));
		return "issues/detail";
	}
	
	//タスクを削除する
	@PostMapping("/delete")
	public String delete(@RequestParam("issueId") long issueId,Model model) {
			model.addAttribute("issue", issueService.deleteId(issueId));
		return"redirect:/issues";
	}
}
