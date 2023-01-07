package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.entity.State;
import by.skopinau.rescue.hr.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StateController {
    @Autowired
    private StateService sService;

    @GetMapping("/state")
    public String showStateList(Model model) {
        List<State> stateList = sService.findAll();
        Map<State, Integer> mapWithActualPositionsAmounts = new HashMap<>();
        Map<State, Integer> mapWithFreePositionsAmounts = new HashMap<>();

        for (State state: stateList) {
            mapWithActualPositionsAmounts.put(state, sService.getActualPositionAmount(state));
            mapWithFreePositionsAmounts.put(state, sService.getFreePositionAmount(state));
        }

        model.addAttribute("stateList", stateList);
        model.addAttribute("actualAmounts", mapWithActualPositionsAmounts);
        model.addAttribute("freeAmounts", mapWithFreePositionsAmounts);

        return "state";
    }
}
