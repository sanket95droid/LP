package passmacro;
import java.io.*;
import java.util.Arrays;

public class pass1 {
	public static void main(String[] args) throws Exception {
		FileReader FR = new FileReader("E:\\Aadi's\\projects\\java\\passmacro\\sourcecode.txt");
		LineNumberReader LR = new LineNumberReader(FR);
		String line = null;
		String MNtable[][] = new String[100][3];
		String MDtable[][] = new String[100][4];
		for(String[] row : MDtable) {
			Arrays.fill(row, "");			
		}
		int MNTcount = 0, MDTcount = 0, LC = 0, MNTptr = 0, MDTptr = 0, flag = 0;
		
		while((line=LR.readLine())!=null) {
			if(line.contains("START")) {
				MNTcount=MDTcount=MNTptr;
				break;
			}
			System.out.println(line);
			LC+=1;
			if(line.contains("MACRO")) {
				String word[] = line.split(" ");
				MNtable[MNTptr][0] = 0+Integer.toString(MNTptr+1);
				MNtable[MNTptr][1] = word[1];
				MNtable[MNTptr][2] = 0+Integer.toString(LC);
				
				MDtable[MDTptr+1][0] = 0+Integer.toString(MDTptr+1);
				MDtable[MDTptr+1][1] = line.replace("MACRO ", "")+"\n\t\t";
				MDtable[MDTptr+1][2] = 0+Integer.toString(LC);
				MDtable[MDTptr+1][3] = "1";
				if(MDtable[MDTptr][3] == "1") {
					MDtable[MDTptr][1] = MDtable[MDTptr][1]+line+"\n\t\t";
				}
				MNTptr+=1;
				MDTptr+=1;
			}
			else if(line.contains("MEND")) {
				MDtable[MDTptr][3] = "0";
				for(int i=0; i<4; i++) {
					if(MDtable[i][3].equalsIgnoreCase("1")) {
						MDTptr-=1;						
					}
				}
			}
			if(MDTptr>=0 && !line.contains("MEND") && !line.contains("MACRO")) {
				MDtable[MDTptr][1] = MDtable[MDTptr][1]+line+"\n\t\t";
			}
		}
		//print POT table
		System.out.println("\n\t MN TABLE");
		System.out.println("------------------------");
		System.out.println("Sr.No.\tName\tIndex");
		System.out.println("------------------------");
		for(int i=0; i<MNTptr; i++)
			System.out.println(MNtable[i][0] + "\t" + MNtable[i][1] + "\t" + MNtable[i][2]);
		System.out.println("------------------------");
		
		//print MOT table
		System.out.println("\n\t MD TABLE");
		System.out.println("----------------------------------");
		System.out.println("Sr.No.\tIndex\tDefinition");
		System.out.println("----------------------------------");
		for(int i=1; i<=MNTptr; i++)
			System.out.println(MDtable[i][0] + "\t" + MDtable[i][2] + "\t" + MDtable[i][1]);
		System.out.println("----------------------------------");
		
		//print MNTC & MDTC
		System.out.println("MNTC: "+MNTcount);
		System.out.println("MDTC: "+MDTcount);
		
		//print code
		System.out.println("\n\tCODE with MACRO Definition\nSTART");
		while((line=LR.readLine())!=null) {		
			String[] word = line.split(" ");
			for(int i=0; i<word.length; i++) {
				for(int a=0; a<MNTcount; a++) {
					if(MNtable[a][1].equalsIgnoreCase(word[i])) {
						line = line.replace(line, MDtable[a+1][1]).replace("\t", "");
					}
					
				}
			}
			
			System.out.println(line);
			
		}
	}

}
