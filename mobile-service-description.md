## Mobile service API description

### Mobile token
##### Use this to obtain mobile token
POST https://sandbox.cardpay.com/api/mobile/token <br>
Authentication: Bearer token.  <br>
All details are presented [here](https://integration.unlimit.com/api-reference/qd9z1pow8j9hd-api-tokens-obtaining) <br>
Request example:
```json
{
  "request": {
    "id": "c93e0f98-6ba4-4581-be90-1c7798eaa87d",
    "time": "2023-08-13T15:23:39.614Z"
  }
}
```
Response example:
```json
{
  "mobile_token": "3e72ee1cc4d24ff364e50ed59cdd2a6bc0543b5be1f8fd55cd717d9bfe84f22f",
  "expires": "2023-08-13T15:33:40Z"
}
```

### Get payment status and token
##### Use this to obtain card token and check status of payment
All details are presented [here](https://integration.unlimit.com/api-reference/6300d5bb967bd-get-payment-information) <br>
GET https://sandbox.cardpay.com/api/payments/{payment_id} <br>
Response example:
```json
{
  "customer": {
    "email": "customer@example.com",
    "full_name": "John Smith"
  },
  "payment_method": "BANKCARD",
  "merchant_order": {
    "description": "Premium Cotton T-Shirt",
    "id": "256437"
  },
  "payment_data": {
    "amount": 100,
    "arn": "string",
    "auth_code": "string",
    "created": "2019-02-04T07:18:56Z",
    "currency": "USD",
    "id": "4323322323",
    "status": "AUTHORIZED"
  },
  "card_account": {
    "acct_type": "03",
    "card_brand": "string",
    "card_type": "DEBIT",
    "expiration": "10/2020",
    "holder": "John Smith",
    "issuer": "string",
    "issuing_country_code": "US",
    "masked_pan": "400000...0002",
    "token": "E2C42154EDD7525771774D82713D952D"
  }
}
```

### Update payment
##### Use this to confirm payment (end of two-phase payment)
All details are presented [here](https://integration.unlimit.com/api-reference/99a98b3f0344d-update-payment) <br>
POST  https://sandbox.cardpay.com/api/payments <br>
Request example:
```json
{
  "request": {
    "id": "1",
    "time": "2022-03-20T09:09:49Z"
  },
  "operation": "CHANGE_STATUS",
  "payment_data": {
    "amount": 100,
    "status_to": "COMPLETE"
  }
}
```
Response example:
```json
{
  "customer": {
    "email": "customer@example.com",
    "full_name": "John Smith"
  },
  "payment_method": "BANKCARD",
  "merchant_order": {
    "description": "Premium Cotton T-Shirt",
    "id": "256437"
  },
  "payment_data": {
    "amount": 100,
    "arn": "string",
    "auth_code": "string",
    "created": "2019-02-04T07:18:56Z",
    "currency": "USD",
    "id": "4323322323",
    "status": "COMPLETED"
  },
  "card_account": {
    "acct_type": "03",
    "card_brand": "string",
    "card_type": "DEBIT",
    "expiration": "10/2020",
    "holder": "John Smith",
    "issuer": "string",
    "issuing_country_code": "US",
    "masked_pan": "400000...0002",
    "token": "E2C42154EDD7525771774D82713D952D"
  }
}
```

### Get COF payment status
##### Use this to obtain subscription id or filing id
All details are presented [here](https://integration.unlimit.com/api-reference/d32cfbbd90466-get-recurring-information) <br>
GET https://sandbox.cardpay.com/api/payments/{recurring_id} <br>
Response example:
```json
{
  "payment_method": "BANKCARD",
  "merchant_order": {
    "id": "9c75f697-767c-41e3-a981-2cfcf780bcf7",
    "description": "Postman Collection Order ('Create first SM payment')"
  },
  "recurring_data": {
    "id": "15435233",
    "filing": {
      "id": "09427DEC20EE45DFE0634801150A333E"
    },
    "status": "COMPLETED",
    "amount": 12.34,
    "currency": "USD",
    "created": "2023-11-03T15:53:27Z",
    "auth_code": "L9PJTX",
    "is_3d": false,
    "note": "Reduced 24/7 interface",
    "type": "SCHEDULED",
    "initiator": "cit",
    "network_trans_id": "VkPoF8pBQyMEL9l1",
    "scheduled_type": "SM"
  },
  "card_account": {
    "masked_pan": "400000...0002",
    "holder": "Ms. Hazel Treutel",
    "issuing_country_code": "US"
  },
  "customer": {
    "id": "Arnaldo79",
    "email": "customer@email.com",
    "ip": "54.86.50.139",
    "locale": "en",
    "phone": "257-802-3563"
  }
}
```
