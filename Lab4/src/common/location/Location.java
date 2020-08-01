package common.location;

/**
 * һ��immutable�����ͣ���ʾλ��
 */
public class Location {
	private final String name;
	private final boolean sharable;
	private final double longitude;
	private final double latitude;

	// Abstraction function:
	// AF(name, sharable)=��nameΪ���ƣ��Ƿ�ɹ���Ϊsharable��λ��
	// AF(name, sharable, longitude,latitude)=��nameΪ���ƣ�
	// �Ƿ�ɹ���Ϊsharable������longitude����γlatitude��λ��
	// Representation invariant:
	// longitude>=0 && longitude<=180
	// latitude>=0 && latitude<=90
	// Safety from rep exposure:
	// ���е���������˽�е���ʹ��final�޶�

	/**
	 * ����һ��λ��
	 * 
	 * @param place    λ�õ�����,�ǿ�
	 * @param sharable λ���Ƿ�ɹ�����trueΪ�ɹ�����falseΪ���ɹ���
	 */
	public Location(String place, boolean sharable) {
		if (place == null) // place����������ǿ��������׳��쳣
			throw new IllegalArgumentException("����Ϊ��");
		this.name = place;
		this.sharable = sharable;
		this.latitude = 0;
		this.longitude = 0;
		checkRep();
	}

	/**
	 * ����һ��λ��
	 * 
	 * @param place     λ�õ����֣��ǿ�
	 * @param sharable  λ���Ƿ�ɹ�����trueΪ�ɹ�����falseΪ���ɹ���
	 * @param longitude ��������
	 * @param latitude  ��γγ��
	 */
	public Location(String place, boolean sharable, double longitude, double latitude) {
		// ����������ǰ���������׳��쳣
		if (place == null)
			throw new IllegalArgumentException("����Ϊ��");
		if (longitude < 0 || longitude > 180 || latitude < 0 || latitude > 90)
			throw new IllegalArgumentException("��γ�Ȳ��Ϸ�");
		this.name = place;
		this.sharable = sharable;
		this.latitude = latitude;
		this.longitude = longitude;
		checkRep();
	}

	/**
	 * ��鲻����
	 */
	private void checkRep() {
		assert this.name != null;
		assert this.longitude >= 0 && this.longitude <= 180;
		assert this.latitude >= 0 && this.latitude <= 90;
	}

	/**
	 * ���λ�õ�����
	 * 
	 * @return һ���ǿ��ַ�������ʾ���ص���
	 */
	public String getName() {
		checkRep();
		return name;
	}

	/**
	 * �ص��Ƿ�Ϊ�ɹ�����
	 * 
	 * @return true �ص��ǿɹ����� false ���ɹ���
	 */
	public boolean isSharable() {
		checkRep();
		return sharable;
	}

	/**
	 * ��þ���
	 * 
	 * @return һ������������ʾ��������
	 */
	public double getLongitude() {
		checkRep();
		return longitude;
	}

	/**
	 * ���γ��
	 * 
	 * @return һ������������ʾ��γγ��
	 */
	public double getLatitude() {
		checkRep();
		return latitude;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object location) {
		if (location instanceof Location) {
			Location loc = (Location) location;
			if (this.name.equals(loc.getName()) && this.sharable == loc.isSharable() && this.longitude == loc.longitude
					&& this.latitude == loc.latitude)
				return true;
		}
		return false;
	}

}