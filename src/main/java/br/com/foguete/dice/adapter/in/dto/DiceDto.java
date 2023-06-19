package br.com.foguete.dice.adapter.in.dto;


import br.com.foguete.dice.adapter.domain.Dado;

public class DiceDto {

    private Dado dice;

    public DiceDto() {
    }

    public Dado getDice() {
        return dice;
    }

    public DiceDto setDice(Dado dice) {
        this.dice = dice;
        return this;
    }
}
