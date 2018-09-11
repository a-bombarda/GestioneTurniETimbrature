package gestioneOrariData;

import java.util.Date;

public interface QueryPermessiFerie {
	public void updateFerie(float val, Date data);
	public void updatePermessi(float val, Date data);
	public float getFerie(Date data);
	public float getPermessi(Date data);
}
