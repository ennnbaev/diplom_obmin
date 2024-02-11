package com.ps.repo;

import com.ps.Dao;
import com.ps.domain.ChangeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Repository
public class Repository
{
    @Autowired Dao dao;

    @Transactional public ModelAndView findNecessaryGame(ChangeInfo changeInfo)
    {
        ModelAndView model = new ModelAndView("listGames");
        model.addObject("games", dao.findNewOrder(changeInfo));
        return model;
    }

    @Transactional public ModelAndView saveNecessaryGame(ChangeInfo changeInfo)
    {
        ModelAndView model = new ModelAndView("yourOrder");
        model.addObject("order", dao.saveNewOrder(changeInfo));
        return model;
    }
}
