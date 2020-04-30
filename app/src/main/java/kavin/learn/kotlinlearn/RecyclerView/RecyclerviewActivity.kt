package kavin.learn.kotlinlearn.RecyclerView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import kavin.learn.kotlinlearn.R
import kotlinx.android.synthetic.main.activity_recyclerview.*

class RecyclerviewActivity : AppCompatActivity() {

    val animals: ArrayList<String> = ArrayList()
    lateinit var animalAdapter:AnimalAdapter;
    var gridStatus:Boolean=false
    var oreientaion:Boolean=false
    var oreientaion_status:String="vertical"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        addAnimals()

        eg_recyclerview.layoutManager = LinearLayoutManager(this)
        animalAdapter= AnimalAdapter( this,animals,oreientaion_status)
        eg_recyclerview.adapter =animalAdapter

        btn_horizontal.setOnClickListener(){

            if (oreientaion){
                oreientaion=false
                oreientaion_status="vertical"
                eg_recyclerview.layoutManager = LinearLayoutManager(this)
                animalAdapter.notifyDataSetChanged()
            }else{
                oreientaion=true
                oreientaion_status="horizontal"
                eg_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true)
                animalAdapter.notifyDataSetChanged()
            }
        }

        btn_grid.setOnClickListener(){
            if (gridStatus) {
                gridStatus=false
                btn_grid.setText("Grid")
                eg_recyclerview.layoutManager = LinearLayoutManager(this)
                animalAdapter.notifyDataSetChanged()
            }else{
                gridStatus=true
                btn_grid.setText("List")
                eg_recyclerview.layoutManager = GridLayoutManager(this, 2)
                animalAdapter.notifyDataSetChanged()
            }
        }
    }

    fun addAnimals() {
        animals.add("dog")
        animals.add("cat")
        animals.add("owl")
        animals.add("cheetah")
        animals.add("raccoon")
        animals.add("bird")
        animals.add("snake")
        animals.add("lizard")
        animals.add("hamster")
        animals.add("bear")
        animals.add("lion")
        animals.add("tiger")
        animals.add("horse")
        animals.add("frog")
        animals.add("fish")
        animals.add("shark")
        animals.add("turtle")
        animals.add("elephant")
        animals.add("cow")
        animals.add("beaver")
        animals.add("bison")
        animals.add("porcupine")
        animals.add("rat")
        animals.add("mouse")
        animals.add("goose")
        animals.add("deer")
        animals.add("fox")
        animals.add("moose")
        animals.add("buffalo")
        animals.add("monkey")
        animals.add("penguin")
        animals.add("parrot")
    }
}
