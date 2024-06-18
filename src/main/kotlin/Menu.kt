import java.util.Scanner

open class Menu() {
    var menuText = ""
    private var scanner = Scanner(System.`in`)

    constructor(menuText: String): this()   {
        this.menuText = menuText
    }

    open fun getCommand(): String {
        val command : String
        command = scanner.nextLine()
        return command
    }
}