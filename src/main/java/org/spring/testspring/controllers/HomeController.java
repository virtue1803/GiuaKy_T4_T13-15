package org.spring.testspring.controllers;

import jakarta.websocket.server.PathParam;
import org.spring.testspring.services.impl.CandidateService;
import org.spring.testspring.services.impl.ExperienceSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    private CandidateService candidateService;
    @Autowired
    private ExperienceSerivce experienceSerivce;

    @GetMapping("/candidates")
    public String listCandidates(Model model) {
        model.addAttribute("listCandidates", candidateService.findAll());

        return "candidates";
    }

    @GetMapping("/view-detail")
    public String viewDetailCandidate(Model model, @PathParam("id") String id) {
        model.addAttribute("candidateDetail", candidateService.findById(Long.parseLong(id)));
        return "candidate_detail";
    }

    @GetMapping("/report1")
    public String findCandidateByCompanyName(Model model) {
        model.addAttribute("listCandidatesByCompanyName", experienceSerivce.findAllByCompanyName(null));
        return "report1";
    }

    @GetMapping("/findCompany")
    public String findCandidateByCompanyName(Model model, @RequestParam("companyName") String company) {
        model.addAttribute("listCandidatesByCompanyName", experienceSerivce.findAllByCompanyName(company));
        return "report1";
    }

    @GetMapping("/report2")
    public String findCandidatesAtLeast5Years(Model model) {
        model.addAttribute("listExperiences", experienceSerivce.findCandidatesWithAtLeast5Years());
        return "report2";
    }
}
