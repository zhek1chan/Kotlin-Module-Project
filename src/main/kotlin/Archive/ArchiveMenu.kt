package Archive
import Menu
import Notes.Notes
import Notes.NotesMenu
import java.util.*

class ArchiveMenu(
) : Menu{

    val archiveMenu: MutableList<Archive> = mutableListOf(
            Archive("Создать архив", mutableListOf()),
            Archive("Выход", mutableListOf())
    )
    val scanner: Scanner = Scanner(System.`in`)
    val notesMenu = NotesMenu()

    override fun show() {
        println("АРХИВЫ:")
        for(i in 0 until archiveMenu.size - 1) {
            println("$i. ${archiveMenu.get(i).name}")
        }
    }

    override fun add() {
        println("Введите название архива")
        val userInput = Scanner(System.`in`).nextLine()
        archiveMenu.add(archiveMenu.size - 1, Archive(userInput, mutableListOf()))
    }

    fun interact(): MutableList<Notes> {
        while (true) {
            try {
                show()
                val userInputMenuItem = Scanner(System.`in`).nextInt()
                if ((userInputMenuItem > archiveMenu.size - 1) or (userInputMenuItem < 0)) {
                    println("Введите число в рамках предложенных вариантов")
                    continue
                }
                when (userInputMenuItem) {
                    0 -> add()
                    archiveMenu.size - 1 -> System.exit(0)
                    else -> notesMenu.interact(archiveMenu.get(userInputMenuItem).notesList)
                }
            } catch (e: java.util.InputMismatchException) {
                println("Введите число в рамках предложенных вариантов")
            }
        }
    }
}


