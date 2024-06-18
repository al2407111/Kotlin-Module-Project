class ArhiveCreate:Menu() {
    var archiveCreate = Menu(

        "СОЗДАНИЕ АРХИВА\n" +
                "Введите номер архива либо \n0 - Создать архив "
    )
    var noteCreate = Menu(

        "ВЫБОР ЗАМЕТКИ"

    )
    private val archiveList:  MutableList<Arhive> = mutableListOf()

    fun printMenu() {

        while (true) {
//
            println(archiveCreate.menuText)

            for (i in 0..archiveList.size - 1) {
                println("${i + 1} - ${archiveList.get(i)}")
            }

            println("${archiveList.size + 1} - Выход")
            val command=getCommand()

            if(!isInt(command)) {
                println("Ошибка: надо ввести целое число!")
                continue}
            if (command.toInt() == archiveList.size + 1) {
                println("Вы вышли из приложения")
                break
            }
            if (command == "0"){
                println("Название архива")
                val archiveName=getCommand()
                archiveList.add(archiveList.size , Arhive(archiveName))
                println("Архив добавлен: $archiveName")
                continue
            }
            if(command.toInt() > (archiveList.size +1)) {
                println("Ошибка: такого пункта меню нет. Попробуйте еще раз!")
                continue
            }
            if(command.toInt() <0) {
                println("Ошибка: число должно быть целым положительным!")
                continue
            }
            else{


                while (true){
                    val archive = archiveList[command.toInt() - 1]
                    archive.caseNote()
                    val commandNote=getCommand()
                    if(!isInt(commandNote)) {
                        println("Ошибка: надо ввести целое число!")
                        continue}
                    if (commandNote.toInt() == archive.noteListSize() + 1) {
                        break
                    }
                    if (commandNote == "0") {
                        println("Название заметки")
                        val noteName = getCommand()
                        println("Содержание заметки")
                        val noteInfo = getCommand()
                        archive.addNote(Note(noteName, noteInfo))
                        println("Заметка добавлена: $noteName")
                        continue
                    }

                    if(commandNote.toInt() > (archive.noteListSize() +1)) {
                        println("Ошибка: такого пункта меню нет. Попробуйте еще раз!")
                        continue
                    }
                    if(commandNote.toInt() <0) {
                        println("Ошибка: число должно быть целым положительным!")
                        continue
                    }
                    else {
                        println(archive.noteList[commandNote.toInt()-1])
                    }

                }
                continue


            }
        }
        fun getCommand(): String {
            return super.getCommand()
        }
    }

}
fun isInt(str: String) = try {
    str.toInt()
    true
} catch (e: NumberFormatException) {
    false
}