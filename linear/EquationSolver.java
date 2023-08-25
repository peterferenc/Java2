package linear;

class EquationSolver{
    public static void main(String[] args) {
        double[][] Matrix = new double[args.length][args[0].split(",").length];
        for(int i = 0; i < args.length; i++){
            Matrix[i] = stringsToDoubles(args[i].split(","));
        }

        linear.algebra.GaussianElimination g = new linear.algebra.GaussianElimination(Matrix.length, Matrix[0].length, Matrix);
        /*for (int i = 0; i < Matrix.length; i++) {
            for (int j = 0; j < Matrix[0].length; j++) {
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }*/
        g.print();
        g.rowEchelonForm();
        System.out.println();
        g.print();
        g.backSubstitution();
        System.out.println();
        g.print();
    }

    public static double[] stringsToDoubles(String[] nums){
        double[] doubles = new double[nums.length];
        for(int i = 0; i < nums.length; i++){
            doubles[i] = Double.parseDouble(nums[i]);
        }
        return doubles;
    }
}