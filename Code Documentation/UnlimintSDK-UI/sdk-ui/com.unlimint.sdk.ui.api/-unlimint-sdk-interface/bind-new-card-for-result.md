//[sdk-ui](../../../index.md)/[com.unlimint.sdk.ui.api](../index.md)/[UnlimintSdkInterface](index.md)/[bindNewCardForResult](bind-new-card-for-result.md)



# bindNewCardForResult  
[androidJvm]  
Content  
abstract fun [bindNewCardForResult](bind-new-card-for-result.md)(activity: [AppCompatActivity](https://developer.android.com/reference/kotlin/androidx/appcompat/app/AppCompatActivity.html), mobileAuthorizationToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), bindingMethodData: [Binding.Data](../../com.unlimint.sdk.ui.api.model/-binding/-data/index.md), environment: , launcher: [ActivityResultLauncher](https://developer.android.com/reference/kotlin/androidx/activity/result/ActivityResultLauncher.html)<[Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)>)  
More info  


Binds bank card. If bank card was bound, rewrites it



*Mandatory params*



#### Return  


You have to catch the answer from [launcher](bind-new-card-for-result.md)



If resultCode is [Activity.RESULT_OK](https://developer.android.com/reference/kotlin/android/app/Activity.html#result_ok) then SDK provides:

<ul><li>last 4 digits of card number. Use [UnlimintSdk.ARG_LAST_4_DIGITS](../-unlimint-sdk/-a-r-g_-l-a-s-t_4_-d-i-g-i-t-s.md) flag to get data from [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)</li><li>transaction id. Use [UnlimintSdk.TransactionData.TRANSACTION_ID](../-unlimint-sdk/-transaction-data/-t-r-a-n-s-a-c-t-i-o-n_-i-d.md) flag to get data from [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)</li></ul>

If resultCode is [Activity.RESULT_CANCELED](https://developer.android.com/reference/kotlin/android/app/Activity.html#result_canceled) then SDK provides:

<ul><li>[UnlimintSdkException](../../com.unlimint.sdk.ui.api.exceptions/-unlimint-sdk-exception/index.md). Use [UnlimintSdk.ARG_EXCEPTION](../-unlimint-sdk/-a-r-g_-e-x-c-e-p-t-i-o-n.md) flag to get exception from [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)</li><li>transaction id. Id may not be present. Use [UnlimintSdk.TransactionData.TRANSACTION_ID](../-unlimint-sdk/-transaction-data/-t-r-a-n-s-a-c-t-i-o-n_-i-d.md) flag to get data from [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html)</li></ul>

If [Intent](https://developer.android.com/reference/kotlin/android/content/Intent.html) is empty, then a user just closed the SDK.



Use LocalBroadcast for catching security error with Intent([UnlimintSdk.SecurityData.SECURITY_ACTION](../-unlimint-sdk/-security-data/-s-e-c-u-r-i-t-y_-a-c-t-i-o-n.md)) and [UnlimintSdk.SecurityData.SECURITY_EXTRA](../-unlimint-sdk/-security-data/-s-e-c-u-r-i-t-y_-e-x-t-r-a.md) key



## Parameters  
  
androidJvm  
  
| | |
|---|---|
| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>activity| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>for calling our Activity<br><br>|
| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>mobileAuthorizationToken| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>Mobile token received from Unlimint (authentication mobile token)<br><br>|
| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>bindingMethodData| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>needed information for binding<br><br>|
| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a>launcher| <a name="com.unlimint.sdk.ui.api/UnlimintSdkInterface/bindNewCardForResult/#androidx.appcompat.app.AppCompatActivity#kotlin.String#com.unlimint.sdk.ui.api.model.Binding.Data#Environments#androidx.activity.result.ActivityResultLauncher[android.content.Intent]/PointingToDeclaration/"></a><br><br>ActivityResultLauncher instance received after registering for activity result<br><br>|
  
  



