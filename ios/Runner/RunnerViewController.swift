import UIKit

class RunnerViewController: UIViewController {

    private var titleLabel = UILabel()

    override func viewDidLoad() {
        super.viewDidLoad()

        titleLabel.frame = CGRect(x: UIScreen.main.bounds.width/2-50, y: 100, width: 100, height: 50)
        titleLabel.frame.size.width = UIScreen.main.bounds.width
        titleLabel.frame.origin.x = 0
        titleLabel.frame.origin.y = 200
        titleLabel.textAlignment = .center
        titleLabel.text = "RunnerViewController"

        view.addSubview(titleLabel)
        view.backgroundColor = .white

        // バッテリーのモニタリング
        UIDevice.current.isBatteryMonitoringEnabled = true

        let bLevel:Float = UIDevice.current.batteryLevel

        if(bLevel == -1){
            titleLabel.text = "Battery Level: ?"
        }
        else{
            titleLabel.text = "Battery Level:  \(bLevel * 100) %"
        }
        
        // Battery Status
        var state:String = "Battery Status: "
        
        if UIDevice.current.batteryState == UIDevice.BatteryState.unplugged {
            state += "Unplugged"
        }
        
        if UIDevice.current.batteryState == UIDevice.BatteryState.charging {
            state += "Charging"
        }
        
        if UIDevice.current.batteryState == UIDevice.BatteryState.full {
            state += "Full"
        }
        
        if UIDevice.current.batteryState == UIDevice.BatteryState.unknown {
            state += "Unknown"
        }
        
        titleLabel.text = state
    }

    @objc func action() {
        titleLabel.text = "Log count" + Int.random(in: 1..<10).description
    }
}
