package com.example.webkiosk.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.webkiosk.entity.Option;
import com.example.webkiosk.repository.OptionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OptionService {
	private final OptionRepository optionRepository;

	public void saveOption(Long userNum, String optionName, int optionPrice, String optionImage) {
		Option option = new Option();
		option.setUserNum(userNum);
		option.setOptionName(optionName);
		option.setOptionPrice(optionPrice);
		option.setOptionImage(optionImage);
		optionRepository.save(option);
	}

	public List<Option> getOptionByProductIdAndUserNum(Long productId, Long userNum) {
		List<Option> options = optionRepository.getOptionByProductIdAndUserNum(productId, userNum);
		return options;
	}
}
