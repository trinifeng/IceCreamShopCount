import kotlin.math.abs

fun main() {
    val supply = arrayOf("cones", "bowls", "scoopers", "ice cream machines", "hot fudge", "fruit", "cookie dough")
    var qty = arrayOf("20", "13", "3", "4", "6", "8", "2")

    var combArray = arrayOf<Array<String>>()
    combArray += supply
    combArray += qty

    print("What item in the ice cream shop supply do you want to search for? ")
    var item = readln()

    for(i in 0..combArray[0].size - 1){
        if(combArray[0][i] == item)
        {
            println("The $item in the ice cream shop has ${combArray[1][i]} items.")
            println("How much do you want to add or subtract from the $item? Enter a negative number if you want to subtract or 0 if the quantity hasn't changed.")
            var old_qty = combArray[1][i]
            var change = readln().toInt()
            var add_or_subtract: String = ""
            var new_qty = old_qty.toInt() + change
            if(change < 0)
            {
                add_or_subtract = "taken away"
                change = abs(change)
            }
            else
                add_or_subtract = "added"
            if(new_qty < 0)
            {
                println("Error: the quantity of the item is less than 0. Setting total to 0 instead.")
                new_qty = 0
            }
            combArray[1][i] = new_qty.toString()
            println("The $item in the ice cream shop was originally at $old_qty items. After $change was $add_or_subtract, the $item is now at $new_qty items.")
            break
        }
        else if(i == combArray[0].size - 1)
            println("Could not find your item, sorry.")
    }
}