/*
 * Sorting code: TBM
 * Binary search code: TBM
 * 
 * header comments:
 * code comments:
 */

import java.util.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.beans.*;
//Imports All Needed Code


public class MainScreen extends JFrame {
	// Start of The Main Code
	public JPanel contentPane;
	// Creates The The JPannel
	public JTextField nameField;
	public JTextField searchField;
	// Creates The Text Field That Will Be Used For Search And
	public JLabel nameLabel;
	public JLabel gradeLabel;
	public JLabel topLabel;
	public JLabel logLabel;
	public JLabel searchLabel;
	public JLabel middleLabel;
	// Creates The JLabels That Will Be Used For Search And
	public JTextArea textArea;
	// Creates The Text Area That Will Display What's Happening
	public JComboBox gradeBox;
	// Creates The Combo Box Where The User Will Choose The Grade
	public JRadioButton editButton;
	public JRadioButton createButton;
	public JRadioButton deleteButton;
	// Creates The Combo Box Where The User Will Choose The Grade
	public JButton anyButton;
	public JButton exitButton;
	public JButton saveButton;
	public JButton searchButton;
	// Creates JButtons That Will Be Used To Add, Edit And Delete Students, Exit The Program, Save The current Students Made, And Search For Specific Students

	static int studentOnList, studentBacklog = 0, totalStudents = 0;
	// Creates integer values that will keep track of the amount of deleted students, total students and a place to see where a specific student is on the list

	public static Students student [] = new Students [900000];
	// Creates a array of records to store the student

	public static void main(String[] args) {
		//Start Of the Code
		EventQueue.invokeLater(new Runnable() {
			// Adds the event that will allow the JFrame to display
			public void run() {
				//Runs the MainScreen method
				try {
					MainScreen frame = new MainScreen();
					// Creates a instance of the MainScreen on the JFrame
					frame.setVisible(true);
					// Sets The Frame As Visible On The Screen
				} catch (Exception e) {
					// If the program can't load
					e.printStackTrace();
					// Program tries to find what went wrong
				}
			}
		});
	}

	public MainScreen() {
		// Start of the method that will create the screen

		String comboList[] = {"Grade 9", "Grade 10", "Grade 11", "Grade 12"};
		// Creates A List For the Contents Of The Combo Box

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 100.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 100.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		// Sets up the content pane and the attributes of the GridB

		topLabel = new JLabel("Student Sorter");
		GridBagConstraints gbc_topLabel = new GridBagConstraints();
		gbc_topLabel.gridwidth = 16;
		gbc_topLabel.insets = new Insets(0, 0, 5, 5);
		gbc_topLabel.gridx = 0;
		gbc_topLabel.gridy = 0;
		contentPane.add(topLabel, gbc_topLabel);
		// Sets Up A Decorative Top Label

		logLabel = new JLabel("Log");
		GridBagConstraints gbc_logLabel = new GridBagConstraints();
		gbc_logLabel.insets = new Insets(0, 0, 5, 0);
		gbc_logLabel.gridx = 16;
		gbc_logLabel.gridy = 0;
		contentPane.add(logLabel, gbc_logLabel);
		// Sets Up A Top Label To Direct People To The Log

		editButton = new JRadioButton("Edit");
		GridBagConstraints gbc_editButton = new GridBagConstraints();
		gbc_editButton.anchor = GridBagConstraints.WEST;
		gbc_editButton.gridwidth = 2;
		gbc_editButton.insets = new Insets(0, 0, 5, 5);
		gbc_editButton.gridx = 0;
		gbc_editButton.gridy = 1;
		contentPane.add(editButton, gbc_editButton);
		// Creates A Radio Button When Selected Will Allow The User To Edit Button

		createButton = new JRadioButton("Create", true);
		GridBagConstraints gbc_createButton = new GridBagConstraints();
		gbc_createButton.gridwidth = 8;
		gbc_createButton.insets = new Insets(0, 0, 5, 5);
		gbc_createButton.gridx = 4;
		gbc_createButton.gridy = 1;
		contentPane.add(createButton, gbc_createButton);
		// Creates A Already Selected Radio Button When Selected Will Allow The User To Create A Student

		deleteButton = new JRadioButton("Delete");
		GridBagConstraints gbc_deleteButton = new GridBagConstraints();
		gbc_deleteButton.anchor = GridBagConstraints.EAST;
		gbc_deleteButton.gridwidth = 2;
		gbc_deleteButton.insets = new Insets(0, 0, 5, 5);
		gbc_deleteButton.gridx = 14;
		gbc_deleteButton.gridy = 1;
		contentPane.add(deleteButton, gbc_deleteButton);
		// Creates A Radio Button When Selected Will Allow The User To Delete Button

		textArea = new JTextArea();
		textArea.setText("Type In The Name And Select The Grade Of The Person You Want To Add To The System\r\n");
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 13;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 16;
		gbc_textArea.gridy = 1;
		contentPane.add(textArea, gbc_textArea);
		// Creates a text field where the outputs will be displayed

		middleLabel = new JLabel("Creation Suite");
		GridBagConstraints gbc_middleLabel = new GridBagConstraints();
		gbc_middleLabel.gridwidth = 16;
		gbc_middleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_middleLabel.gridx = 0;
		gbc_middleLabel.gridy = 3;
		contentPane.add(middleLabel, gbc_middleLabel);
		// Creates a label that directs people to the creation suite

		nameLabel = new JLabel("Student Name");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.gridwidth = 12;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 0;
		gbc_nameLabel.gridy = 5;
		contentPane.add(nameLabel, gbc_nameLabel);
		// Creates A Label To Direct The User On Where To Put the Name Of A Student

		gradeLabel = new JLabel("Grade");
		GridBagConstraints gbc_gradeLabel = new GridBagConstraints();
		gbc_gradeLabel.gridwidth = 4;
		gbc_gradeLabel.insets = new Insets(0, 0, 5, 5);
		gbc_gradeLabel.gridx = 12;
		gbc_gradeLabel.gridy = 5;
		contentPane.add(gradeLabel, gbc_gradeLabel);
		// Creates A Label To Direct The User On Where To Select The grade of The Student

		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.gridwidth = 12;
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 0;
		gbc_nameField.gridy = 6;
		contentPane.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		// Creates A Name Field For The User To Type The Name Of The Student They Want To Add

		gradeBox = new JComboBox (comboList);
		GridBagConstraints gbc_gradeBox = new GridBagConstraints();
		gbc_gradeBox.gridwidth = 4;
		gbc_gradeBox.insets = new Insets(0, 0, 5, 5);
		gbc_gradeBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_gradeBox.gridx = 12;
		gbc_gradeBox.gridy = 6;
		contentPane.add(gradeBox, gbc_gradeBox);
		// Creates A Combo box That Allows The User To Select The Grade Of The Student They Want To Add

		searchLabel = new JLabel("Search Using Student Number");
		GridBagConstraints gbc_searchLabel = new GridBagConstraints();
		gbc_searchLabel.gridwidth = 16;
		gbc_searchLabel.insets = new Insets(0, 0, 5, 5);
		gbc_searchLabel.gridx = 0;
		gbc_searchLabel.gridy = 9;
		contentPane.add(searchLabel, gbc_searchLabel);
		// Creates A Label To Direct The User On Where To Search For A Student

		searchButton = new JButton("Search");
		searchButton.setEnabled(false);
		GridBagConstraints gbc_searchButton = new GridBagConstraints();
		gbc_searchButton.gridwidth = 2;
		gbc_searchButton.insets = new Insets(0, 0, 5, 5);
		gbc_searchButton.gridx = 0;
		gbc_searchButton.gridy = 10;
		contentPane.add(searchButton, gbc_searchButton);
		// Creates A Button When Pressed That Allows The User To Search For A Student Using The Info In the Text Box

		searchField = new JTextField();
		searchField.setEnabled(false);
		searchField.setColumns(10);
		GridBagConstraints gbc_searchField = new GridBagConstraints();
		gbc_searchField.gridwidth = 14;
		gbc_searchField.insets = new Insets(0, 0, 5, 5);
		gbc_searchField.fill = GridBagConstraints.HORIZONTAL;
		gbc_searchField.gridx = 2;
		gbc_searchField.gridy = 10;
		contentPane.add(searchField, gbc_searchField);
		// Creates A Button When Pressed That Allows The User To Search For A Student Using The Info In the Text Box

		anyButton = new JButton("Create");
		GridBagConstraints gbc_anyButton = new GridBagConstraints();
		gbc_anyButton.gridwidth = 16;
		gbc_anyButton.insets = new Insets(0, 0, 5, 5);
		gbc_anyButton.gridx = 0;
		gbc_anyButton.gridy = 7;
		contentPane.add(anyButton, gbc_anyButton);
		// Creates A Button That Handles The Delete, Edit and Add Code

		exitButton = new JButton("Exit");
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.gridwidth = 2;
		gbc_exitButton.insets = new Insets(0, 0, 5, 5);
		gbc_exitButton.gridx = 0;
		gbc_exitButton.gridy = 12;
		contentPane.add(exitButton, gbc_exitButton);
		// Creates A Button When Clicked Exits The Program

		saveButton = new JButton("Save");
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 5, 5);
		gbc_saveButton.gridwidth = 2;
		gbc_saveButton.gridx = 14;
		gbc_saveButton.gridy = 12;
		contentPane.add(saveButton, gbc_saveButton);
		// Creates A Button When Clicked Exits The Program

		ButtonGroup group = new ButtonGroup ();
		group.add (editButton);
		group.add (createButton);
		group.add (deleteButton);
		// Creates A Button Group For The Create, Delete and Edit Buttons

		searchButton.addMouseListener(new MouseAdapter() {
			// Allows The Button To See If It Is Clicked
			public void mouseClicked(MouseEvent e) {
				// When the mouse click's the button
				if(totalStudents == 0) {
					// If the user has created a student already
					int numberWanted = Integer.parseInt(searchField.getText());
					// Creates a value for the number wanted
					for(int i = 0; i <= totalStudents; i++) {
						// For list of the array of records
						if(student[i].studentNumber == numberWanted) {
							// If the student wanted is found
							studentOnList = i;
							// Sets student on list variable 
							searchButton.setEnabled(false);
							searchField.setEnabled(false);
							// Sets The Search Area To Not Be Enabled
							anyButton.setEnabled(true);
							// Sets the Any Button To Enabled
							if(editButton.isSelected()) {
								gradeBox.setEnabled(true);
								nameField.setEnabled(true);
								// Sets Editable Features To True
								textArea.append("Found The Student! Name: " + student[i].studentName + ", Grade: " +student[i].studentGrade + ", Number: " + student[i].studentNumber + ". You Can Now Change The Student In The Creator Suite" +"\n");
								// Tells The User That The Student Was Found And They Can Now Edit The User
								anyButton.setText("Edit");
								// Sets The Any Buttons Text To Edit
							}if(deleteButton.isSelected()) {
								textArea.append("Found The Student! Name: " + student[i].studentName + ", Grade: " +student[i].studentGrade + ", Number: " + student[i].studentNumber + ". Click The Delete Button To Delete The Student" +"\n");
								// Tells The User That The Student Was Found And They Can Now Delete The User
								anyButton.setText("Delete");
								// Sets The Any Buttons Text To Delete
							}
							i=totalStudents;
							// Sets the for loop to the amount of total students to end it
						}else if(i == totalStudents) {
							// If the student couldn't be found
							textArea.append("Couldn't Find The Student Try Again" + "\n");
							// tells the user the student couldn't be found
						}
					}
				}else {
					// If the user has yet to add a student
					textArea.append("Please Create A Student First" +"\n");
					// Tells the user to add a student before editing/deleting a student
				}
			}
		});

		anyButton.addMouseListener(new MouseAdapter() {
			// Allows The Button To See If It Is Clicked
			public void mouseClicked(MouseEvent e) {
				// When the mouse click's the button
				if(createButton.isSelected()) {
					// If the user wants to create a new student
					Random rnd = new Random();
					// Allows program to use random variables
					int randomNumber;
					// Creates a variable for a random number to be generated
					randomNumber = rnd.nextInt(900000) + 100000;
					// Generates a random student number
					for(int i=0; i<totalStudents; i++) {
						// For the length of all possible numbers
						if(randomNumber == student[i].studentNumber) {
							// If a number is the same as a number already possessed by another students
							i=0;
							// Sets the loop back to the beginning
							randomNumber = rnd.nextInt(900000) + 100000;
							// Generates a new random number
						}
					}
					if(studentBacklog > 0) {
						// If there is a backlog of deleted students
						student[totalStudents].changeAllInfo(nameField.getText(), (String)gradeBox.getSelectedItem(), randomNumber);
						// Adds A New Student To The Array using the info given in the combo box and nameField
						studentBacklog--;
						// Lowers the student backlog
					}else {
						// If there is not a backlog
						Students student = new Students(nameField.getText(), (String)gradeBox.getSelectedItem(), randomNumber);
						// Creates a new student to the array using the info given in the combo box and nameField
					}
					textArea.append("Created A New Student Number For " + nameField.getText() + " In " + (String)gradeBox.getSelectedItem() + ": " + randomNumber + "\n");
					// Adds to the text area that a new student has been created
					totalStudents++;
					// Adds To The Total Students

					// Sorting code
					if(totalStudents!=1) {
						// If there are more than 2 students
						for(int x=0; x<totalStudents; x++){
							// For the total amount of students(x value is for the student being compared)
							for(int y=x; y<totalStudents; y++){
								// For the other students in the array(y value is for the other students being compared)
								if(student[x].studentNumber>student[y].studentNumber){
									// If The student being compared has a lower value student number then the current student
									int numberHolder = student[x].studentNumber;
									// Makes a value to hold the number being moved and stores the new number in there
									String nameHolder = student[x].studentName, gradeHolder = student[x].studentGrade;
									// Makes a string value to hold the name and grade being moved and stores the values there
									student[x].changeAllInfo(student[y].studentName, student[y].studentGrade, student[y].studentNumber);
									student[y].changeAllInfo(nameHolder, gradeHolder, numberHolder);
									// Switches info between the two students
								}
							}
						}
					}
					//Sorting Code
					
					for(int i=0; i<totalStudents; i++) {
						System.out.println(student[i].studentNumber);
					}
					
				}if(editButton.isSelected()) {
					// If the user want to save edits of a user
					String previousName = student[studentOnList].studentName, previousGrade = student[studentOnList].studentGrade;
					// Creates variables for their previous information 
					student[studentOnList].changeAllInfo(nameField.getText(), (String)gradeBox.getSelectedItem(), student[studentOnList].studentNumber);
					// Changes The Information Chosen
					textArea.append("Changed Info For Student " + student[studentOnList].studentNumber + ". Name Changed From" + previousName + " To " + student[studentOnList].studentName + ". Grade Changed From " + previousGrade + " To " + student[studentOnList].studentGrade + "\n");
					// Tells the user the info changed
					anyButton.setEnabled(false);
					nameField.setEnabled(false);
					gradeBox.setEnabled(false);
					// Makes it so the creation suite can't be accused
					searchButton.setEnabled(true);
					searchField.setEnabled(true);
					// Makes the search area enabled again
				}if(deleteButton.isSelected()) {
					// If the user wants to delete a user
					textArea.append("Deleted " + student[studentOnList].studentName + "(" + student[studentOnList].studentNumber + ") In " + student[studentOnList].studentGrade + " From The System" + "\n");
					// Tells the user the student was deleted
					for(int i=studentOnList; i<totalStudents; i++) {
						// For the length of all the students on the list from the point of deletion
						student[i].changeAllInfo(student[i+1].studentName, student[i+1].studentGrade, student[i+1].studentNumber);
						// Moves the data from the student above on the array to the new spot
					}
					student[totalStudents].changeAllInfo(null, null, 0);
					// For the student at the end, it changes its information to null
					totalStudents--;
					// Takes away from the total students
					studentBacklog++;
					// Adds to the backlog
					anyButton.setEnabled(false);
					// Makes it so the any button can't be accessed without a new student id
					searchButton.setEnabled(true);
					searchField.setEnabled(true);
					// Makes the search area enabled again
				}
			}
		});

		createButton.addItemListener(new ItemListener() {
			// Allows The Button To See If It Gets Changed
			public void itemStateChanged(ItemEvent e) {
				// When the state of the radio button changes
				if(e.getStateChange()==1) {
					// If the create button is selected
					searchButton.setEnabled(false);
					searchField.setEnabled(false);
					// Makes The Search Area Not Accessible
					textArea.append ("Type In The Name And Select The Grade Of The Person You Want To Add To The System" + "\n");
					// Tells the user how to create a student
					anyButton.setText("Create");
					// Changes the text on the any button to create
				}else {
					// If the create button is unselected
					searchButton.setEnabled(true);
					searchField.setEnabled(true);
					// Makes The Search Area Accessible
				}
			}
		});

		editButton.addItemListener(new ItemListener() {
			// Allows The Button To See If It Gets Changed
			public void itemStateChanged(ItemEvent e) {
				// When the state of the radio button changes
				if(e.getStateChange()==1) {
					// If the edit button is selected
					gradeBox.setEnabled(false);
					nameField.setEnabled(false);
					anyButton.setEnabled(false);
					// Makes the creation suite not accessible
					textArea.append ("Type In The Student Number Of The Student You Want To Edit" + "\n");
					// Tells the user how to edit a student
				}else {
					// If the edit button is unselected
					gradeBox.setEnabled(true);
					nameField.setEnabled(true);
					anyButton.setEnabled(true);
					// Makes the creation suite accessible
				}
			}
		});

		deleteButton.addItemListener(new ItemListener() {
			// Allows The Button To See If It Gets Changed
			public void itemStateChanged(ItemEvent e) {
				// When the state of the radio button changes
				if(e.getStateChange()==1) {
					// If the delete button is selected
					gradeBox.setEnabled(false);
					nameField.setEnabled(false);
					anyButton.setEnabled(false);
					// Makes the creation suite not accessible
					textArea.append ("Type In The Student Number Of The Student You Want To Edit" + "\n");
					// Tells the user how to delete a student
				}else {
					// If the delete button is unselected
					gradeBox.setEnabled(true);
					nameField.setEnabled(true);
					anyButton.setEnabled(true);
					// Makes the creation suite accessible
				}
			}
		});
		
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
}
