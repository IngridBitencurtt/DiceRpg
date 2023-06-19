package br.com.foguete.dice.adapter.in;

import br.com.foguete.dice.adapter.domain.Dado;
import br.com.foguete.dice.adapter.in.dto.DiceDto;
import br.com.foguete.dice.adapter.in.dto.ResultDto;
import br.com.foguete.dice.core.DicePortIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dice/v1/")
public class HttpDiceAdapterIn {

    public final DicePortIn dicePortIn;


    public HttpDiceAdapterIn(DicePortIn dicePortIn) {
        this.dicePortIn = dicePortIn;
    }

    @GetMapping
    public ResponseEntity<ResultDto> diceResult(@RequestParam("dice") Dado dadoValor) {
        Integer result = this.dicePortIn.diceResult(dadoValor);

        ResultDto ResultDto = new ResultDto(result);

        return ResponseEntity.ok().body(ResultDto);

    }



    @PostMapping("/result")
    public ResponseEntity<ResultDto> diceResult(@RequestBody DiceDto diceDto) {
        Dado dadoValor = diceDto.getDice();
        Integer result = this.dicePortIn.diceResult(dadoValor);
        ResultDto resultDto = new ResultDto(result);
        return ResponseEntity.ok(resultDto);
    }




}
