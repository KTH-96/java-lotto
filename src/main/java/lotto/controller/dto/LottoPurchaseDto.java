package lotto.controller.dto;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;

public class LottoPurchaseDto {

    private static final int LOTTO_BASIC_AMOUNT = 1000;
    private final int purchaseNumbers;
    private final List<Lotto> lottos;

    public LottoPurchaseDto(int paymentAmount) {
        this.purchaseNumbers = validDivision(paymentAmount);
        this.lottos = purchaseLottos(purchaseNumbers);
    }

    private List<Lotto> purchaseLottos(int purchaseNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (int lottoTicket = 0; lottoTicket < purchaseNumbers; lottoTicket++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        return new Lotto(pickUniqueNumbersInRange(1, 45, 6));
    }

    private int validDivision(int paymentAmount) {
        if (paymentAmount % LOTTO_BASIC_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 지불금액이 1000으로 나누어 떨어지지 않습니다.");
        }
        return paymentAmount / LOTTO_BASIC_AMOUNT;
    }

    public int getPurchaseNumbers() {
        return this.purchaseNumbers;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
