import UIKit

class RunnerViewController: UIViewController {

    private var b = UIButton()
    private var titleLabel = UILabel()

    override func viewDidLoad() {
        super.viewDidLoad()
        b.frame = CGRect(x: UIScreen.main.bounds.width/2-50, y: 100, width: 100, height: 50)
        titleLabel.frame = b.frame
        titleLabel.frame.origin.y = 200
        b.addTarget(self, action: #selector(action), for: .touchUpInside)
        b.backgroundColor = .green
        view.addSubview(b)
        view.addSubview(titleLabel)
        view.backgroundColor = .gray
    }

    @objc func action() {
        titleLabel.text = "Log count" + Int.random(in: 1..<10).description
        titleLabel.textAlignment = .center
    }
}
