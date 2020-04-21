/**
 * SWEN20003 Object Oriented Software Development
 * Project 2b, Semester 2, 2019
 *
 * @description Display all pegs on board
 *              contains layout of every peg on each board
 *              for this project, there are a total of 5 boards
 * @author Nicholas 956970
 */
import java.util.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import bagel.util.Point;

public class Board {
    private ArrayList<Peg> bluepegs=new ArrayList<>();
    private ArrayList<Peg> greypegs=new ArrayList<>();
    private ArrayList<Peg> redpegs=new ArrayList<>();
    public ArrayList<Peg> allpegs=new ArrayList<>();
    private ArrayList<Peg> greenpegs=new ArrayList<>();
    private Peg current;
    private String cshape; //shape of current peg

    public Board(String board) throws IOException {
        String row;
        int bluenum,rednum;

        //read csv line by line adding pegs to their respective arrays
        BufferedReader csvReader = new BufferedReader(new FileReader(board));
        while ((row = csvReader.readLine()) != null) {
            String shape ,name;
            Point pos;
            String[] data = row.split(",");
            pos=new Point(Double.parseDouble(data[1]),Double.parseDouble(data[2]));
            String[] peg =data[0].split("_");
            if (peg.length ==3) {
                shape = peg[2];

                if (peg[0].equals("blue")){
                    name ="res/" + shape +"-peg.png";
                    bluepegs.add(new BluePeg(pos, name,shape));
                }
                else{
                    name ="res/grey-" + shape +"-peg.png";
                    greypegs.add(new GreyPeg(pos, name,shape));
                }
            }
            else{
                if (peg[0].equals("blue")){
                    bluepegs.add(new BluePeg(pos, "res/peg.png",null));
                }
                else{
                    greypegs.add(new GreyPeg(pos, "res/grey-peg.png",null));
                }
            }

        }
        csvReader.close();

        //determine how many red pegs are needed and randomly turn blue pegs red
        bluenum= bluepegs.size();
        rednum= bluenum/5;
        Collections.shuffle(bluepegs);
        for (int i=0; i<rednum; ++i){
            current = bluepegs.remove(i);
            cshape=current.getShape();
            if (cshape==null){
                redpegs.add(new RedPeg(current.getPoint(),"res/red-peg.png", null));
            }else{
                redpegs.add(new RedPeg(current.getPoint(),"res/red-"+cshape+"-peg.png",cshape));
            }

        }

        //turn one blue peg green
        Collections.shuffle(bluepegs);
        current=bluepegs.remove(0);
        cshape=current.getShape();
        if (cshape==null){
            greenpegs.add(new GreenPeg(current.getPoint(),"res/green-peg.png", null));
        }else{
            greenpegs.add(new GreenPeg(current.getPoint(),"res/green-"+cshape+"-peg.png",cshape));
        }
    }

    public void turnGreen(){
        Collections.shuffle(bluepegs);
        current=bluepegs.remove(0);
        cshape=current.getShape();
        if (cshape==null){
            greenpegs.add(new GreenPeg(current.getPoint(),"res/green-peg.png",cshape));
        }else{
            greenpegs.add(new GreenPeg(current.getPoint(),"res/green-"+cshape+"-peg.png",cshape));
        }

    }

    public void turnBlue(){
        current=greenpegs.remove(0);
        cshape=current.getShape();
        if (cshape==null){
            bluepegs.add(new BluePeg(current.getPoint(),"res/peg.png",cshape));
        }else{
            bluepegs.add(new BluePeg(current.getPoint(),"res/"+cshape+"-peg.png",cshape));
        }
    }

    public void remove(ArrayList<Peg> remove){
        greenpegs.removeAll(remove);
        bluepegs.removeAll(remove);
        redpegs.removeAll(remove);
    }

    public int lengthGreen(){
        return greenpegs.size();
    }

    public int lengthBlue(){
        return bluepegs.size();
    }

    //destroy all pegs that are within 70 pixels of point
    public void destroy(Point point){
        ArrayList<Peg> boom=new ArrayList<>();
        for (Peg peg:allpegs){
            if (Math.sqrt(Math.pow(peg.getPoint().x-point.x,2)+Math.pow(peg.getPoint().y-point.y,2))<70){
                boom.add(peg);
            }
        }
        greenpegs.removeAll(boom);
        bluepegs.removeAll(boom);
        redpegs.removeAll(boom);
    }

    public int redLeft(){
        return redpegs.size();
    }

    public void update(){
        allpegs.clear();
        allpegs.addAll(greypegs);
        allpegs.addAll(bluepegs);
        allpegs.addAll(redpegs);
        allpegs.addAll(greenpegs);

        for(Peg current :allpegs){
            current.update();
        }



    }


}
