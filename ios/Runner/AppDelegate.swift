import UIKit
import Flutter

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {

    private var flutterViewController: FlutterViewController {
        return self.window.rootViewController as! FlutterViewController
    }

    override func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        let controller: FlutterViewController = window?.rootViewController as! FlutterViewController
        let methodChannel = FlutterMethodChannel(name: "hello_code", binaryMessenger: controller.binaryMessenger)
        methodChannel.setMethodCallHandler({ [weak self]
            (call: FlutterMethodCall, result: FlutterResult) -> Void in
            if call.method == "getData" {
                result("to RunnerViewController")
                self?.launchNativeScreen()
            } else {
                result(FlutterMethodNotImplemented)
            }
        })
        GeneratedPluginRegistrant.register(with: self)
        return super.application(application, didFinishLaunchingWithOptions: launchOptions)
    }
    private func launchNativeScreen() {
        let viewController: RunnerViewController = RunnerViewController()
        flutterViewController.present(viewController, animated: true, completion: nil)
    }
}
