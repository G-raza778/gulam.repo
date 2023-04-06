package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/*
 * this class contains reusable number within the limit.
 * @paramlimit
 * @return
 */
public class javaUtility {
public int generateRandomNum(int limit) {
	Random random=new Random();
	int randomNum=random.nextInt(limit);
	return randomNum;
}
public String getCurrentTime() {
	/*
	 * This method returns current time in specified format
	 * @return
	 */
	Date date=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy=hh-mm-ss");
	String currentTime=sdf.format(date);
	return currentTime;
}
}
