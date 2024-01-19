package studio.midoridesign.vibrator;

import androidx.annotation.NonNull;
import android.os.Vibrator;
import android.os.VibrationEffect;
import android.content.Context;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

/** VibratorPlugin */
public class VibratorPlugin implements FlutterPlugin, MethodCallHandler {
  private MethodChannel channel;
  private FlutterPluginBinding pluginBinding;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "vibrator");
    channel.setMethodCallHandler(this);
    pluginBinding = flutterPluginBinding;
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    switch (call.method) {
      case "vibrate":
        vibrate();
        result.success(null);
        break;
      case "heavyImpact":
        heavyImpact();
        result.success(null);
        break;
      default:
        result.notImplemented();
        break;
    }
  }

  private void vibrate() {
    Context context = pluginBinding.getApplicationContext();
    Vibrator vibrator = context.getSystemService(Vibrator.class);
    vibrator.vibrate(VibrationEffect.createOneShot(400, VibrationEffect.DEFAULT_AMPLITUDE));
  }

  private void heavyImpact() {
    Context context = pluginBinding.getApplicationContext();
    Vibrator vibrator = context.getSystemService(Vibrator.class);
    vibrator.vibrate(VibrationEffect.createPredefined(VibrationEffect.EFFECT_HEAVY_CLICK));
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }
}
