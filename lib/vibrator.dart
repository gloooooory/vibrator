import 'package:vibrator/vibrator_method_channel.dart';

final class Vibrator {
  const Vibrator._();
  static Future<void> vibrate() async => MethodChannelVibrator.vibrate();
  static Future<void> heavyImpact() async =>
      MethodChannelVibrator.heavyImpact();
}
