package christmas.Global;

import christmas.DTO.ResultDTO;

public enum ResultPhrase {

    ORDER_MENU("<주문 메뉴>") {
        @Override
        public String getPhrase(ResultDTO resultDTO) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.phrase);
            sb.append("\n");
            sb.append(resultDTO.getOrderMenu());
            sb.append("\n");
            return sb.toString();
        }
    },

    BEFORE_DISCOUNT_ORDER_PRICE("<할인 전 총주문 금액>") {
        @Override
        public String getPhrase(ResultDTO resultDTO) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.phrase);
            sb.append("\n");
            sb.append(resultDTO.getBeforeDiscountOrderPrice());
            sb.append("\n");
            return sb.toString();
        }
    },

    PRESENT_MENU("<증정 메뉴>") {
        @Override
        public String getPhrase(ResultDTO resultDTO) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.phrase);
            sb.append("\n");
            sb.append(resultDTO.getPresentMenu());
            sb.append("\n");
            return sb.toString();
        }
    },
    BENEFIT_INFORMATION("<혜택 내역>") {
        @Override
        public String getPhrase(ResultDTO resultDTO) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.phrase);
            sb.append("\n");
            sb.append(resultDTO.getBenefitInformation());
            sb.append("\n");
            return sb.toString();
        }
    },

    WHOLE_BENEFIT_PRICE("<총혜택 금액>") {
        @Override
        public String getPhrase(ResultDTO resultDTO) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.phrase);
            sb.append("\n");
            sb.append(resultDTO.getWholeBenefitPrice());
            sb.append("\n");
            return sb.toString();
        }
    },

    AFTER_DISCOUNT_ORDER_PRICE("<할인 후 예상 결제 금액>") {
        @Override
        public String getPhrase(ResultDTO resultDTO) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.phrase);
            sb.append("\n");
            sb.append(resultDTO.getAfterDiscountOrderPrice());
            sb.append("\n");
            return sb.toString();
        }
    },
    EVENT_BADGE_INFORMATION("<12월 이벤트 배지>") {
        @Override
        public String getPhrase(ResultDTO resultDTO) {
            StringBuilder sb = new StringBuilder();
            sb.append(super.phrase);
            sb.append("\n");
            sb.append(resultDTO.getEventBadge());
            sb.append("\n");
            return sb.toString();
        }
    };

    protected final String phrase;

    private ResultPhrase(String phrase) {
        this.phrase = phrase;
    }

    public abstract String getPhrase(ResultDTO resultDTO);


}
