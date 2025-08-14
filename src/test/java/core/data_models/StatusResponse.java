package core.data_models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class StatusResponse {
    @JsonProperty("order")
    private Order order;

    @JsonProperty("pay_form")
    private PayForm payForm;

    @JsonProperty("payment_adviser")
    private PaymentAdviser paymentAdviser;

    @JsonProperty("order_metadata")
    private OrderMetadata orderMetadata;

    @JsonProperty("redirect_url")
    private String redirectUrl;

    @JsonProperty("device_info")
    private DeviceInfo deviceInfo;

    @JsonProperty("transactions")
    private Map<String, Transaction> transactions;

    @JsonProperty("three_ds")
    private ThreeDs threeDs;

    @JsonProperty("routing")
    private Routing routing;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PayForm getPayForm() {
        return payForm;
    }

    public void setPayForm(PayForm payForm) {
        this.payForm = payForm;
    }

    public PaymentAdviser getPaymentAdviser() {
        return paymentAdviser;
    }

    public void setPaymentAdviser(PaymentAdviser paymentAdviser) {
        this.paymentAdviser = paymentAdviser;
    }

    public OrderMetadata getOrderMetadata() {
        return orderMetadata;
    }

    public void setOrderMetadata(OrderMetadata orderMetadata) {
        this.orderMetadata = orderMetadata;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfo deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public Map<String, Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Map<String, Transaction> transactions) {
        this.transactions = transactions;
    }

    public ThreeDs getThreeDs() {
        return threeDs;
    }

    public void setThreeDs(ThreeDs threeDs) {
        this.threeDs = threeDs;
    }

    public Routing getRouting() {
        return routing;
    }

    public void setRouting(Routing routing) {
        this.routing = routing;
    }

    public static class Order {
        @JsonProperty("order_id")
        private String orderId;

        @JsonProperty("amount")
        private Integer amount;

        @JsonProperty("currency")
        private String currency;

        @JsonProperty("mid")
        private String mid;

        @JsonProperty("descriptor")
        private String descriptor;

        @JsonProperty("fraudulent")
        private Boolean fraudulent;

        @JsonProperty("marketing_amount")
        private Integer marketingAmount;

        @JsonProperty("marketing_currency")
        private String marketingCurrency;

        @JsonProperty("processing_amount")
        private Integer processingAmount;

        @JsonProperty("processing_currency")
        private String processingCurrency;

        @JsonProperty("status")
        private String status;

        @JsonProperty("refunded_amount")
        private Integer refundedAmount;

        @JsonProperty("order_description")
        private String orderDescription;

        @JsonProperty("traffic_source")
        private String trafficSource;

        @JsonProperty("customer_email")
        private String customerEmail;

        @JsonProperty("auth_code")
        private String authCode;

        @JsonProperty("ip_address")
        private String ipAddress;

        @JsonProperty("psp_order_id")
        private String pspOrderId;

        @JsonProperty("provider_payment_id")
        private String providerPaymentId;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getDescriptor() {
            return descriptor;
        }

        public void setDescriptor(String descriptor) {
            this.descriptor = descriptor;
        }

        public Boolean getFraudulent() {
            return fraudulent;
        }

        public void setFraudulent(Boolean fraudulent) {
            this.fraudulent = fraudulent;
        }

        public Integer getMarketingAmount() {
            return marketingAmount;
        }

        public void setMarketingAmount(Integer marketingAmount) {
            this.marketingAmount = marketingAmount;
        }

        public String getMarketingCurrency() {
            return marketingCurrency;
        }

        public void setMarketingCurrency(String marketingCurrency) {
            this.marketingCurrency = marketingCurrency;
        }

        public Integer getProcessingAmount() {
            return processingAmount;
        }

        public void setProcessingAmount(Integer processingAmount) {
            this.processingAmount = processingAmount;
        }

        public String getProcessingCurrency() {
            return processingCurrency;
        }

        public void setProcessingCurrency(String processingCurrency) {
            this.processingCurrency = processingCurrency;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Integer getRefundedAmount() {
            return refundedAmount;
        }

        public void setRefundedAmount(Integer refundedAmount) {
            this.refundedAmount = refundedAmount;
        }

        public String getOrderDescription() {
            return orderDescription;
        }

        public void setOrderDescription(String orderDescription) {
            this.orderDescription = orderDescription;
        }

        public String getTrafficSource() {
            return trafficSource;
        }

        public void setTrafficSource(String trafficSource) {
            this.trafficSource = trafficSource;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getAuthCode() {
            return authCode;
        }

        public void setAuthCode(String authCode) {
            this.authCode = authCode;
        }

        public String getIpAddress() {
            return ipAddress;
        }

        public void setIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
        }

        public String getPspOrderId() {
            return pspOrderId;
        }

        public void setPspOrderId(String pspOrderId) {
            this.pspOrderId = pspOrderId;
        }

        public String getProviderPaymentId() {
            return providerPaymentId;
        }

        public void setProviderPaymentId(String providerPaymentId) {
            this.providerPaymentId = providerPaymentId;
        }
    }

    public static class PayForm {
        @JsonProperty("token")
        private String token;

        @JsonProperty("form_url")
        private String formUrl;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getFormUrl() {
            return formUrl;
        }

        public void setFormUrl(String formUrl) {
            this.formUrl = formUrl;
        }
    }

    public static class PaymentAdviser {
        @JsonProperty("advise")
        private String advise;

        public String getAdvise() {
            return advise;
        }

        public void setAdvise(String advise) {
            this.advise = advise;
        }
    }

    public static class OrderMetadata {
        @JsonProperty("partner_id")
        private String partnerId;

        @JsonProperty("coupon_code")
        private String couponCode;

        public String getPartnerId() {
            return partnerId;
        }

        public void setPartnerId(String partnerId) {
            this.partnerId = partnerId;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public void setCouponCode(String couponCode) {
            this.couponCode = couponCode;
        }
    }

    public static class DeviceInfo {
        @JsonProperty("user_agent")
        private String userAgent;

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }
    }

    public static class Transaction {
        @JsonProperty("id")
        private String id;

        @JsonProperty("operation")
        private String operation;

        @JsonProperty("status")
        private String status;

        @JsonProperty("descriptor")
        private String descriptor;

        @JsonProperty("amount")
        private Integer amount;

        @JsonProperty("currency")
        private String currency;

        @JsonProperty("created_at")
        private String createdAt;

        @JsonProperty("updated_at")
        private String updatedAt;

        @JsonProperty("marketing_amount")
        private Integer marketingAmount;

        @JsonProperty("marketing_currency")
        private String marketingCurrency;

        @JsonProperty("card")
        private Card card;

        @JsonProperty("card_token")
        private CardToken cardToken;

        @JsonProperty("scheme_transaction_id")
        private String schemeTransactionId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDescriptor() {
            return descriptor;
        }

        public void setDescriptor(String descriptor) {
            this.descriptor = descriptor;
        }

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getMarketingAmount() {
            return marketingAmount;
        }

        public void setMarketingAmount(Integer marketingAmount) {
            this.marketingAmount = marketingAmount;
        }

        public String getMarketingCurrency() {
            return marketingCurrency;
        }

        public void setMarketingCurrency(String marketingCurrency) {
            this.marketingCurrency = marketingCurrency;
        }

        public Card getCard() {
            return card;
        }

        public void setCard(Card card) {
            this.card = card;
        }

        public CardToken getCardToken() {
            return cardToken;
        }

        public void setCardToken(CardToken cardToken) {
            this.cardToken = cardToken;
        }

        public String getSchemeTransactionId() {
            return schemeTransactionId;
        }

        public void setSchemeTransactionId(String schemeTransactionId) {
            this.schemeTransactionId = schemeTransactionId;
        }
    }

    public static class Card {
        @JsonProperty("bin")
        private String bin;

        @JsonProperty("brand")
        private String brand;

        @JsonProperty("number")
        private String number;

        @JsonProperty("card_holder")
        private String cardHolder;

        @JsonProperty("bank")
        private String bank;

        @JsonProperty("country")
        private String country;

        @JsonProperty("card_exp_month")
        private String cardExpMonth;

        @JsonProperty("card_exp_year")
        private Integer cardExpYear;

        @JsonProperty("card_type")
        private String cardType;

        @JsonProperty("card_token")
        private CardToken cardToken;

        @JsonProperty("card_id")
        private String cardId;

        public String getBin() {
            return bin;
        }

        public void setBin(String bin) {
            this.bin = bin;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getCardHolder() {
            return cardHolder;
        }

        public void setCardHolder(String cardHolder) {
            this.cardHolder = cardHolder;
        }

        public String getBank() {
            return bank;
        }

        public void setBank(String bank) {
            this.bank = bank;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCardExpMonth() {
            return cardExpMonth;
        }

        public void setCardExpMonth(String cardExpMonth) {
            this.cardExpMonth = cardExpMonth;
        }

        public Integer getCardExpYear() {
            return cardExpYear;
        }

        public void setCardExpYear(Integer cardExpYear) {
            this.cardExpYear = cardExpYear;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public CardToken getCardToken() {
            return cardToken;
        }

        public void setCardToken(CardToken cardToken) {
            this.cardToken = cardToken;
        }

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }

    public static class CardToken {
        @JsonProperty("token")
        private String token;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }

    public static class ThreeDs {
        @JsonProperty("eci")
        private Integer eci;

        @JsonProperty("flow")
        private String flow;

        public Integer getEci() {
            return eci;
        }

        public void setEci(Integer eci) {
            this.eci = eci;
        }

        public String getFlow() {
            return flow;
        }

        public void setFlow(String flow) {
            this.flow = flow;
        }
    }

    public static class Routing {
        @JsonProperty("cascade_steps")
        private List<CascadeStep> cascadeSteps;

        public List<CascadeStep> getCascadeSteps() {
            return cascadeSteps;
        }

        public void setCascadeSteps(List<CascadeStep> cascadeSteps) {
            this.cascadeSteps = cascadeSteps;
        }
    }

    public static class CascadeStep {
        @JsonProperty("mid")
        private String mid;

        @JsonProperty("mid_descriptor")
        private String midDescriptor;

        @JsonProperty("route_id")
        private String routeId;

        @JsonProperty("cascade_number")
        private Integer cascadeNumber;

        @JsonProperty("segment_id")
        private String segmentId;

        public String getMid() {
            return mid;
        }

        public void setMid(String mid) {
            this.mid = mid;
        }

        public String getMidDescriptor() {
            return midDescriptor;
        }

        public void setMidDescriptor(String midDescriptor) {
            this.midDescriptor = midDescriptor;
        }

        public String getRouteId() {
            return routeId;
        }

        public void setRouteId(String routeId) {
            this.routeId = routeId;
        }

        public Integer getCascadeNumber() {
            return cascadeNumber;
        }

        public void setCascadeNumber(Integer cascadeNumber) {
            this.cascadeNumber = cascadeNumber;
        }

        public String getSegmentId() {
            return segmentId;
        }

        public void setSegmentId(String segmentId) {
            this.segmentId = segmentId;
        }
    }
}
