import 'package:flutter/material.dart';
import 'package:vibrator/vibrator.dart';

void main() => runApp(const App());

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Center(
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              FilledButton(
                onPressed: () async => Vibrator.vibrate(),
                child: const Text('Vibrate'),
              ),
              FilledButton(
                onPressed: () async => Vibrator.heavyImpact(),
                child: const Text('Heavy Impact'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
