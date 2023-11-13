package com.cat.encrypt;

/**
 * @author 14629
 */
public class EncryptSituation {
    private boolean returnEncrypted = true;
    private boolean cancelEncrypt = false;

    @SuppressWarnings("all")
    public boolean isReturnEncrypted() {
        return this.returnEncrypted;
    }

    @SuppressWarnings("all")
    public boolean isCancelEncrypt() {
        return this.cancelEncrypt;
    }

    @SuppressWarnings("all")
    public void setReturnEncrypted(final boolean returnEncrypted) {
        this.returnEncrypted = returnEncrypted;
    }

    @SuppressWarnings("all")
    public void setCancelEncrypt(final boolean cancelEncrypt) {
        this.cancelEncrypt = cancelEncrypt;
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EncryptSituation)) return false;
        final EncryptSituation other = (EncryptSituation) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.isReturnEncrypted() != other.isReturnEncrypted()) return false;
        if (this.isCancelEncrypt() != other.isCancelEncrypt()) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof EncryptSituation;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + (this.isReturnEncrypted() ? 79 : 97);
        result = result * PRIME + (this.isCancelEncrypt() ? 79 : 97);
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "EncryptSituation(returnEncrypted=" + this.isReturnEncrypted() + ", cancelEncrypt=" + this.isCancelEncrypt() + ")";
    }

    @SuppressWarnings("all")
    public EncryptSituation(final boolean returnEncrypted, final boolean cancelEncrypt) {
        this.returnEncrypted = returnEncrypted;
        this.cancelEncrypt = cancelEncrypt;
    }

    @SuppressWarnings("all")
    public EncryptSituation() {
    }
}
