class Archive(val name:String) {
    override fun toString(): String {
        return name
    }

    val noteList: MutableList<Note> = mutableListOf()
    fun addNote(note: Note) {
        noteList.add(noteList.size,note)
    }


    fun caseNote(){
        println("СОЗДАНИЕ ЗАМЕТКИ\n" +
                "Введите номер заметки либо \n0 - Создать заметку ")
        for (i in 0..noteList.size - 1) {
            println("${i + 1} - ${noteList.get(i).name}")
        }
        println("${noteList.size + 1} - Выход")
    }

    fun noteListSize():Int{
        return noteList.size
    }
}