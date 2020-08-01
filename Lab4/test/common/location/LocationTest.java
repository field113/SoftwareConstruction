package common.location;

import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

import org.junit.Test;
import org.junit.Rule;

public class LocationTest {

	// Test strategy
	// ���Թ��췽��
	// �ص�Ϊ�գ��ص㲻Ϊ��
	// ��γ���ڷ�Χ�ڣ���γ�Ȳ��ڷ�Χ��
	// ����getName()
	// ���Է��ص������������Ƿ���ͬ
	// ����isSharable()
	// ���Է��صĿɹ������������Ƿ���ͬ
	// ����getLongitude()
	// ���Է��صľ����������Ƿ���ͬ
	// ����getLatitude()
	// ���Է��ص�γ���������Ƿ���ͬ
	// ����hashCode()
	// ���Է��صĹ�ϣֵ�������Ƿ���ͬ
	// ����equals()
	// ��λ����ͬ����λ�ò�ͬ

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	// tests for Location
	@Test
	public void testLocation1(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("����Ϊ��");
		new Location(null, true);
	}

	public void testLocation2(){
		new Location("A", true);
	}

	@Test
	public void testLocation3(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("����Ϊ��");
		new Location(null, true, 100, 80);
	}

	@Test
	public void testLocation4(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("��γ�Ȳ��Ϸ�");
		new Location("A", true, 190, 90);
	}

	@Test
	public void testLocation5(){
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("��γ�Ȳ��Ϸ�");
		new Location("A", true, 100, 100);
	}

	@Test
	public void TestLocation6(){
		new Location("A", true, 100, 50);
	}

	//tests for getName()
	@Test
	public void testGetName() {
		Location loc = new Location("place", true);
		assertEquals("place", loc.getName());
	}

	//tests for isSharable()
	@Test
	public void testIsSharable() {
		Location loc = new Location("place", true);
		assertTrue(loc.isSharable());
	}

	//tests for getLongitude()
	@Test
	public void testGetLongitude() {
		Location loc = new Location("place", true, 100, 50);
		assertEquals(100, loc.getLongitude(), 0.0);
	}

	//tests for getLatitude()
	@Test
	public void testGetLatitude() {
		Location loc = new Location("place", true, 100, 50);
		assertEquals(50, loc.getLatitude(), 0.0);
	}

	//tests for hashCode()
	@Test
	public void testHashCode() {
		Location loc = new Location("place", true);
		assertEquals("place".hashCode(), loc.hashCode());
	}

	//tests for equals()
	@Test
	public void testEquals() {
		Location loc1 = new Location("place1", true);
		//��λ�����
		Location loc2 = new Location("place1", true);
		assertTrue(loc1.equals(loc2));
		//��λ�ò����
		Location loc3 = new Location("place3", true);
		assertFalse(loc1.equals(loc3));
	}
}