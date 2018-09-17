package com.company.Regex.IPAddress;

import com.company.Regex.IValidator;

public class ScoreValidator implements IValidator<Integer> {

    private Integer score;

    public ScoreValidator(Integer score){
        this.score = score;
    }

    @Override
    public boolean validate(Integer content) {
        return score <= 100 && score >= 0;
    }
}
