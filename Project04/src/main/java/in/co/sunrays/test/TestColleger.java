package in.co.sunrays.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.sunrays.bean.CollegeBean;
import in.co.sunrays.exception.DuplicateRecordException;
import in.co.sunrays.model.CollegeModel;

public class TestColleger {

	public static void main(String[] args) throws Exception {

		// testDelete();

		// testUpdate();

		// testAdd();

		// testFindbyname();

		// testFindbypk();

		testSearch();
	}

	public static void testSearch() {
		try {
			CollegeBean bean = new CollegeBean();

			CollegeModel mode = new CollegeModel();

			List list = new ArrayList();

			 bean.setName("Ferr");

			list = mode.search(bean, 1, 3);

			if (list.size() < 0) {
				System.out.println("Search Failed");

			}
			Iterator it = list.iterator();
			while (it.hasNext()) {
				bean = (CollegeBean) it.next();
				System.out.println(bean.getId() + "  " + bean.getName() + "  " + bean.getAddress());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void testFindbypk() throws Exception {

		CollegeBean cub = new CollegeBean();

		CollegeModel cim = new CollegeModel();

		cub = cim.findByPK(1);

		System.out.println(cub.getName() + "  " + cub.getCity());

	}

	public static void testFindbyname() throws Exception {

		CollegeBean cub = new CollegeBean();

		CollegeModel cim = new CollegeModel();

		cub = cim.findByName("Ferrari");

		System.out.println(cub.getName() + "  " + cub.getCity());

	}

	public static void testUpdate() throws Exception {

		CollegeBean cub = new CollegeBean();
		cub.setId(1);
		cub.setName("Alpine College");
		cub.setAddress("Mayajaal");
		cub.setCity("Nepal");
		cub.setState("New York");
		cub.setPhoneNo("987455444");
		cub.setCreatedBy("Charr");

		CollegeModel cim = new CollegeModel();

		cim.update(cub);
	}

	public static void testDelete() throws Exception {
		CollegeBean cub = new CollegeBean();

		CollegeModel cim = new CollegeModel();
		cub.setId(3);

		cim.delete(cub);

	}

	public static void testAdd() throws DuplicateRecordException {
		try {

			CollegeBean cub = new CollegeBean();

			CollegeModel cim = new CollegeModel();

			cub.setName("Nexa");
			cub.setAddress("Chinu");
			cub.setCity("Nepur");
			cub.setState("Tamis Danu");
			cub.setPhoneNo("78978455");
			cub.setCreatedBy("Miku");
			cub.setModifiedBy("Miku");
			long pk = cim.add(cub);
			System.out.println("Test and Success");
		} catch (Exception r) {
			r.printStackTrace();
		}
	}

}
