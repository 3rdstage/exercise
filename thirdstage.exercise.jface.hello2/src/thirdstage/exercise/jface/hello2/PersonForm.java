package thirdstage.exercise.jface.hello2;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;
//import org.eclipse.swt.widgets.Button;
//import org.eclipse.swt.widgets.Combo;
//import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.widgets.Label;
//import org.eclipse.swt.widgets.Layout;
//import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import thirdstage.exercise.jface.hello2.model.Address;
import thirdstage.exercise.jface.hello2.model.Person;

public class PersonForm extends ViewPart {
	public static final String ID = "thirdstage.exercise.jface.hello2.view.personform";

	private Person person;

	private Text firstNameText;
	private Text ageText;
	private Button marriedButton;
	private Combo genderCombo;
	private Text countryText;

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	@Override
	public void createPartControl(Composite parent) {

		person = new Person();
		Address address = new Address();
		address.setCountry("Korea");
		person.setAddress(address);
		person.setFirstName("Lee");
		person.setLastName("Cheulsu");
		person.setGender("Male");
		person.setAge(12);
		person.setMarried(true);

		Layout layout = new GridLayout(2, false);
		parent.setLayout(layout);

		Label firstNameLabel = new Label(parent, SWT.NONE);
		firstNameLabel.setText("Firstname: ");
		firstNameText = new Text(parent, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		firstNameText.setLayoutData(gridData);

		Label ageLabel = new Label(parent, SWT.NONE);
		ageLabel.setText("Age: ");
		ageText = new Text(parent, SWT.BORDER);
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		ageText.setLayoutData(gridData);

		Label marriedLabel = new Label(parent, SWT.NONE);
		marriedLabel.setText("Married: ");
		this.marriedButton = new Button(parent, SWT.CHECK);

		Label genderLabel = new Label(parent, SWT.NONE);
		genderLabel.setText("Gender: ");
		this.genderCombo = new Combo(parent, SWT.NONE);
		genderCombo.add("Male");
		genderCombo.add("Female");

		Label countryLabel = new Label(parent, SWT.NONE);
		countryLabel.setText("Country: ");
		countryText = new Text(parent, SWT.BORDER);

		Button button1 = new Button(parent, SWT.PUSH);
		button1.setText("Write model");
		button1.addSelectionListener(
			new SelectionAdapter(){

				@Override
				public void widgetSelected(SelectionEvent e){
					System.out.println("Firstname: " + person.getFirstName());
					System.out.println("Age: " + person.getAge());
					System.out.println("Married: " + person.isMarried());
					System.out.println("Gender: " + person.getGender());
					System.out.println("Country: " + person.getAddress().getCountry());
				}
			}
		);

		Button button2 = new Button(parent, SWT.PUSH);
		button2.setText("Change model");
		button2.addSelectionListener(
			new SelectionAdapter(){

				@Override
				public void widgetSelected(SelectionEvent e){
					person.setFirstName("Choi");
					person.setAge(person.getAge() + 1);
					person.setMarried(!person.isMarried());
					person.setGender("Male".equals(person.getGender()) ? "Female" : "Male");
					if("Korea".equals(person.getAddress().getCountry())){
						person.getAddress().setCountry("Switchland");
					}else{
						person.getAddress().setCountry("Korea");
					}
				}
			}
		);

		this.bindValue();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {

	}

	private void bindValue(){

		DataBindingContext bindingContext = new DataBindingContext();
		bindingContext.bindValue(
			WidgetProperties.text(SWT.Modify).observe(this.firstNameText),
			BeanProperties.value(Person.class, "firstName").observe(this.person)
		);

		bindingContext.bindValue(
			WidgetProperties.text(SWT.Modify).observe(this.ageText),
			BeanProperties.value(Person.class, "age").observe(this.person)
		);

		bindingContext.bindValue(
			WidgetProperties.selection().observe(this.marriedButton),
			BeanProperties.value(Person.class, "married").observe(this.person)
		);

		bindingContext.bindValue(
			WidgetProperties.selection().observe(this.genderCombo),
			BeansObservables.observeValue(person, "gender")
		);

		Binding bindValue = bindingContext.bindValue(
			WidgetProperties.text(SWT.Modify).observe(this.countryText),
			BeanProperties.value(Person.class, "address.country").observe(this.person)
		);

		//ControlDecorationSupport.create(bindValue, SWT.TOP | SWT.RIGHT);
	}
}