import 'package:flutter/services.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(title: 'Flutter EventChannel API Example'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);
  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String _platformMessage;

  @override
  Widget build(BuildContext context) {
    final _channel = MethodChannel('hello_code');
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Your Platform-> $_platformMessage',
            ),
          ],
        ),
      ),
    floatingActionButton:
    FloatingActionButton(
      onPressed: () async {
        final message = await _channel.invokeMethod('getData');
        setState(() {
          _platformMessage = message;
        });
      },
      tooltip: 'Increment',
      child: Icon(Icons.add),
    )
    );
  }
}