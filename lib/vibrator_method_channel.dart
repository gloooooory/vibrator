import 'package:flutter/services.dart';

const _channel = MethodChannel('vibrator');

final class MethodChannelVibrator {
  const MethodChannelVibrator._();

  static Future<void> vibrate() async => _channel.invokeMethod<void>('vibrate');
  static Future<void> heavyImpact() async =>
      _channel.invokeMethod<void>('heavyImpact');
}
