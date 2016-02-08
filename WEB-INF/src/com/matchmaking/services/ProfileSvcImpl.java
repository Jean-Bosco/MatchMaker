package com.matchmaking.services;
import com.matchmaking.domain.ProfileBean;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ProfileSvcImpl {

	public ProfileBean getProfile() {
		ProfileBean profile = new ProfileBean();
		try {

			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File("sampleProfile.xml"));

			// normalize text representation
			doc.getDocumentElement().normalize();
			System.out.println("Root element of the doc is "
					+ doc.getDocumentElement().getNodeName());

			NodeList listOfPersons = doc.getElementsByTagName("profile");
			int totalPersons = listOfPersons.getLength();
			System.out.println("Total no of people : " + totalPersons);

			for (int s = 0; s < listOfPersons.getLength(); s++) {

				Node firstPersonNode = listOfPersons.item(s);
				if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {

					Element firstPersonElement = (Element) firstPersonNode;

					// -------
					NodeList firstNameList = firstPersonElement
							.getElementsByTagName("firstName");
					Element firstNameElement = (Element) firstNameList.item(0);

					NodeList textFNList = firstNameElement.getChildNodes();
					profile.setFirstName(((Node) textFNList.item(0))
							.getNodeValue().trim());
					// -------
					NodeList lastNameList = firstPersonElement
							.getElementsByTagName("lastName");
					Element lastNameElement = (Element) firstNameList.item(0);

					NodeList textLNList = lastNameElement.getChildNodes();
					profile.setLastName(((Node) textLNList.item(0))
							.getNodeValue().trim());
					// -------

					NodeList EmailList = firstPersonElement
							.getElementsByTagName("email");
					Element emailElement = (Element) EmailList.item(0);

					NodeList textEmList = emailElement.getChildNodes();
					profile.setEmail(((Node) textEmList.item(0)).getNodeValue()
							.trim());
					// -------
					NodeList PassList = firstPersonElement
							.getElementsByTagName("password");
					Element passElement = (Element) PassList.item(0);

					NodeList textDescList = passElement.getChildNodes();
					profile.setPassword(((Node) textDescList.item(0))
							.getNodeValue().trim());
					// -------
					NodeList descriptionList = firstPersonElement
							.getElementsByTagName("description");
					Element descriptionElement = (Element) descriptionList
							.item(0);

					NodeList textdescList = descriptionElement.getChildNodes();
					profile.setFirstName(((Node) textdescList.item(0))
							.getNodeValue().trim());
					// -------

					NodeList interestsList = firstPersonElement
							.getElementsByTagName("interests");
					Element interestsElement = (Element) interestsList.item(0);

					NodeList textInterList = interestsElement.getChildNodes();
					profile.setFirstName(((Node) textInterList.item(0))
							.getNodeValue().trim());
					// -------

					NodeList occupationList = firstPersonElement
							.getElementsByTagName("occupation");
					Element occupationElement = (Element) occupationList
							.item(0);

					NodeList textOccList = occupationElement.getChildNodes();
					profile.setFirstName(((Node) textOccList.item(0))
							.getNodeValue().trim());
					// -------
					NodeList locationList = firstPersonElement
							.getElementsByTagName("location");
					Element locationElement = (Element) locationList.item(0);

					NodeList textLocList = locationElement.getChildNodes();
					profile.setFirstName(((Node) textLocList.item(0))
							.getNodeValue().trim());
					// -------

				}// end of if clause

			}// end of for loop with s var

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line "
					+ err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
		// System.exit (0);
		return profile;

	}//

}