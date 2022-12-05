import 'package:flutter/material.dart'; 
void main() => runApp(MyApp());

class MyApp extends StatelessWidget { @override
Widget build(BuildContext context) { return MaterialApp(
  home: MyNavigationBar (),
);
}
}

/// This Widget is the main application widget. class MyApp extends StatelessWidget { @override
Widget build(BuildContext context) { return MaterialApp(
  home: MyNavigationBar (),
);
}


class MyNavigationBar extends StatefulWidget {
//MyNavigationBar ({Key key}) : super(key: key);

  @override
  _MyNavigationBarState createState() => _MyNavigationBarState();
}

class _MyNavigationBarState extends State<MyNavigationBar > { int _selectedIndex = 0;
static const List<Widget> _widgetOptions = <Widget>[
  Text('Home Page', style: TextStyle(fontSize: 35, fontWeight: FontWeight.bold)), Text('Search Page', style: TextStyle(fontSize: 35, fontWeight: FontWeight.bold)), Text('Profile Page', style: TextStyle(fontSize: 35, fontWeight: FontWeight.bold)),
];

void _onItemTapped(int index) { setState(() {
  _selectedIndex = index;
});
}

@override
Widget build(BuildContext context) { return Scaffold(
  appBar: AppBar(
      title: const Text('Flutter BottomNavigationBar Example'), backgroundColor: Colors.green
  ),
  body: Center(
    child: _widgetOptions.elementAt(_selectedIndex),
  ),
  bottomNavigationBar: BottomNavigationBar(

      items: const <BottomNavigationBarItem>[ BottomNavigationBarItem(
          icon: Icon(Icons.home), label: 'Home',
          backgroundColor: Colors.green
      ),
        BottomNavigationBarItem( icon: Icon(Icons.search), label: 'Search',
            backgroundColor: Colors.yellow
        ),
        BottomNavigationBarItem( icon: Icon(Icons.person), label: 'Profile',
          backgroundColor: Colors.blue,
        ),
      ],
      type: BottomNavigationBarType.shifting, currentIndex: _selectedIndex, selectedItemColor: Colors.black, iconSize: 40,
      onTap: _onItemTapped, elevation: 5
  ),
);
}
}



class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  // This widget is the home page of your application. It is stateful, meaning
  // that it has a State object (defined below) that contains fields that affect
  // how it looks.

  // This class is the configuration for the state. It holds the values (in this
  // case the title) provided by the parent (in this case the App widget) and
  // used by the build method of the State. Fields in a Widget subclass are
  // always marked "final".

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      // This call to setState tells the Flutter framework that something has
      // changed in this State, which causes it to rerun the build method below
      // so that the display can reflect the updated values. If we changed
      // _counter without calling setState(), then the build method would not be
      // called again, and so nothing would appear to happen.
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
      appBar: AppBar(
        // Here we take the value from the MyHomePage object that was created by
        // the App.build method, and use it to set our appbar title.
        title: Text(widget.title),
      ),
      body: Center(
        // Center is a layout widget. It takes a single child and positions it
        // in the middle of the parent.
        child: Column(
          // Column is also a layout widget. It takes a list of children and
          // arranges them vertically. By default, it sizes itself to fit its
          // children horizontally, and tries to be as tall as its parent.
          //
          // Invoke "debug painting" (press "p" in the console, choose the
          // "Toggle Debug Paint" action from the Flutter Inspector in Android
          // Studio, or the "Toggle Debug Paint" command in Visual Studio Code)
          // to see the wireframe for each widget.
          //
          // Column has various properties to control how it sizes itself and
          // how it positions its children. Here we use mainAxisAlignment to
          // center the children vertically; the main axis here is the vertical
          // axis because Columns are vertical (the cross axis would be
          // horizontal).
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            const Text(
              'You have pushed the button this many times:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headline4,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: const Icon(Icons.add),
      ), // This trailing comma makes auto-formatting nicer for build methods.
    );
  }
}
