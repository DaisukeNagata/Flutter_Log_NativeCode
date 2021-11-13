import UIKit

class RunnerViewController: UIViewController {

    private var b = UIButton()
    private var titleLabel = UILabel()

    override func viewDidLoad() {
        super.viewDidLoad()
        b.frame = CGRect(x: UIScreen.main.bounds.width/2-50, y: 100, width: 100, height: 50)
        b.addTarget(self, action: #selector(action), for: .touchUpInside)
        b.setTitle("Push", for: .normal)
        b.backgroundColor = .lightGray

        titleLabel.frame = b.frame
        titleLabel.frame.size.width = UIScreen.main.bounds.width
        titleLabel.frame.origin.x = 0
        titleLabel.frame.origin.y = 200
        titleLabel.textAlignment = .center
        titleLabel.text = "RunnerViewController"

        view.addSubview(b)
        view.addSubview(titleLabel)
        view.backgroundColor = .white
    }

    @objc func action() {
        titleLabel.text = "Log count" + Int.random(in: 1..<10).description
    }
}
