Unlimint SDK
========

Unlimint mobile SDK helps you to implement payments in your application. Release 1.8 version supports following methods:
- binding card for further recurring payments,
- checking which payment methods are available for you,
- payment with new bank card,
- payment with saved bank card (token),
- recurring with new bank card,
- recurring with saved bank card (token),
- payment with PayPal.

Unlimint SDK has two parts: SDK UI and SDK Core.
SDK UI already contains SDK Core. The former has user interface, root detection and simplified API. It securely collects and transmits user card data. The latter has only payment methods.
We strongly recommend to use SDK UI if you don't have PCI DSS certificate.

## Requirements
- Android 8.0+

## Installation
#### :exclamation: Important: <br>To gain access to nexus repository please contact the Unlimint manager

### SDK-UI (contains SDK-CORE inside)
```ruby
repositories {
    ...
    maven { url "https://nexus-ext-new.cardpay-aws.net/repository/mobile-sdk/" }
}
dependencies {
    ...
    implementation "com.unlimint.sdk:mobile-sdk-ui:1.8.6"
    ...
}
``` 
### SDK-CORE
```ruby
    repositories {
        ...
        maven { url "https://nexus-ext-new.cardpay-aws.net/repository/mobile-sdk/" }
    }
    dependencies {
        ...
        implementation "com.unlimint.sdk:mobile-sdk-core:1.8.6"
        ...
    }
``` 
## Usage
Follow links below to get more information about methods

**Bank card binding**: [MobileSdk.bindNewCardForResult(...)](https://cardpay.github.io/android-sdk-demo/card-binding)<br>
**Payment**: [MobileSdk.paymentForResult(...)](https://cardpay.github.io/android-sdk-demo/card-payment)<br>
**Recurring**: [MobileSdk.recurringForResult(...)](https://cardpay.github.io/android-sdk-demo/card-recurring)

Service interactions described [here](https://cardpay.github.io/android-sdk-demo/interactions)<br>
Mobile service API described [here](https://cardpay.github.io/android-sdk-demo/mobile-service-description)<br>
Also one can apply UI custom colors and text, see [customization](https://cardpay.github.io/android-sdk-demo/customization) page

## Contribution Guide

A guide to [submit issues](https://github.com/cardpay/android-sdk-demo/issues), to ask general questions, or to [open pull requests](https://github.com/cardpay/android-sdk-demo/pulls).
