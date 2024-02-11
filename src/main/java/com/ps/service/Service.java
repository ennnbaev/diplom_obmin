package com.ps.service;

import com.ps.domain.ChangeInfo;
import com.ps.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
@org.springframework.stereotype.Service
public class Service
{
    @Autowired Repository repository;

    public ModelAndView findNecessaryGame(ChangeInfo changeInfo){
        repository.saveNecessaryGame(changeInfo);
        return repository.findNecessaryGame(changeInfo);
    }
}
