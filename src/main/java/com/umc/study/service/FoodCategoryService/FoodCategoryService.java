package com.umc.study.service.FoodCategoryService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FoodCategoryService {
    boolean existAllByIds(List<Long> ids);
}

