Unlimint SDK
========

Unlimint mobile SDK helps you to implement payments in your application. Release 1.8 version supports following methods:
- binding card for further recurring payments,
- checking which payment methods are available for you,
- payment with new bank card,
- payment with saved bank card (token),
- payment with PayPal.

Unlimint SDK has two parts: SDK UI and SDK Core.
SDK UI already contains SDK Core. The former has user interface, root detection and simplified API. It securely collects and transmits user card data. The latter has only payment methods.
We strongly recommend to use SDK UI if you don't have PCI DSS certificate.

**Wise notice**:
Unlimint mobile SDK UI just reminds you that the device is rooted. You can accept working on Rooted devices or reject a payment.

## Try Demo now 
[Download DemoApp](https://github.com/cardpay/android-sdk-demo/releases/download/1.8/app-1.8.2-release.apk)

## Requirements

- Android 4.4+

## Installation
```ruby
repositories {
    ...
    
    maven { url "https://repos.unlimint.io/repository/mobile-sdk/" }
}
dependencies {
    ...
    implementation "com.unlimint.sdk:mobile-sdk:$sdk_version"
    ...
}
``` 
#### Using

```ruby
MobileSdk.bindNewCardForResult(...) //for bankcard binding 
MobileSdk.paymentForResult(...) //for payment
MobileSdk.paymentForResult(saveCard, ...) //for saved card payment

fun onActivityResult(...) // wait for result here
``` 

## Documentation

- [Technical documents](https://github.com/cardpay/android-sdk-demo/wiki).

- [UnlimintSDK-UI documentation](<./Code Documentation/UnlimintSDK-UI/index.md>).
- [UnlimintSDK-Core documentation](<./Code Documentation/UnlimintSDK-Core/index.md>).

## Contribution Guide

A guide to [submit issues](https://github.com/cardpay/android-sdk-demo/issues), to ask general questions, or to [open pull requests](https://github.com/cardpay/android-sdk-demo/pulls).
