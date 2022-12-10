package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.entity.RanksLog;
import by.skopinau.rescue.hr.service.RanksLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static by.skopinau.rescue.hr.config.WebConfig.PAGE_SIZE;

@Controller
public class RanksLogController {
    @Autowired
    private RanksLogService rlService;

    // todo: defaultValue the last page
    @GetMapping("/rank-logs")
    public String showRanksLog(@RequestParam(defaultValue = "1") int page, Model model) {
        List<RanksLog> rl = rlService.findAllPageable(page - 1, PAGE_SIZE);

        model.addAttribute("page", page);
        model.addAttribute("rankLogs", rl);

        return "ranks-log";
    }
}
