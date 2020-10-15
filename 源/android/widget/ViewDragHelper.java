package android.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper {
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;

    /* renamed from: v */
    private static final Interpolator f446v = new Interpolator() {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* renamed from: a */
    private int f447a;

    /* renamed from: b */
    private int f448b;

    /* renamed from: c */
    private int f449c = -1;

    /* renamed from: d */
    private float[] f450d;

    /* renamed from: e */
    private float[] f451e;

    /* renamed from: f */
    private float[] f452f;

    /* renamed from: g */
    private float[] f453g;

    /* renamed from: h */
    private int[] f454h;

    /* renamed from: i */
    private int[] f455i;

    /* renamed from: j */
    private int[] f456j;

    /* renamed from: k */
    private int f457k;

    /* renamed from: l */
    private VelocityTracker f458l;

    /* renamed from: m */
    private float f459m;

    /* renamed from: n */
    private float f460n;

    /* renamed from: o */
    private int f461o;

    /* renamed from: p */
    private int f462p;

    /* renamed from: q */
    private Scroller f463q;

    /* renamed from: r */
    private final Callback f464r;

    /* renamed from: s */
    private View f465s;

    /* renamed from: t */
    private boolean f466t;

    /* renamed from: u */
    private final ViewGroup f467u;

    /* renamed from: w */
    private final Runnable f468w = new Runnable() {
        public void run() {
            ViewDragHelper.this.mo571a(0);
        }
    };

    public static abstract class Callback {
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return 0;
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return 0;
        }

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f467u = viewGroup;
            this.f464r = callback;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f461o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f448b = viewConfiguration.getScaledTouchSlop();
            this.f459m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f460n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f463q = new Scroller(context, f446v);
        }
    }

    /* renamed from: a */
    private float m235a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    /* renamed from: a */
    private float m236a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    /* renamed from: a */
    private int m237a(int i, int i2) {
        int i3 = i < this.f467u.getLeft() + this.f461o ? 1 : 0;
        if (i2 < this.f467u.getTop() + this.f461o) {
            i3 |= 4;
        }
        if (i > this.f467u.getRight() - this.f461o) {
            i3 |= 2;
        }
        return i2 > this.f467u.getBottom() - this.f461o ? i3 | 8 : i3;
    }

    /* renamed from: a */
    private int m238a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f467u.getWidth();
        float f = (float) (width / 2);
        float a = f + (m235a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * f);
        int abs = Math.abs(i2);
        return Math.min(abs > 0 ? Math.round(Math.abs(a / ((float) abs)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    /* renamed from: a */
    private int m239a(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int b = m247b(i3, (int) this.f460n, (int) this.f459m);
        int b2 = m247b(i4, (int) this.f460n, (int) this.f459m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        if (b != 0) {
            f = (float) abs3;
            f2 = (float) i5;
        } else {
            f = (float) abs;
            f2 = (float) i6;
        }
        float f5 = f / f2;
        if (b2 != 0) {
            f3 = (float) abs4;
            f4 = (float) i5;
        } else {
            f3 = (float) abs2;
            f4 = (float) i6;
        }
        float f6 = f3 / f4;
        return (int) ((((float) m238a(i, b, this.f464r.getViewHorizontalDragRange(view))) * f5) + (((float) m238a(i2, b2, this.f464r.getViewVerticalDragRange(view))) * f6));
    }

    /* renamed from: a */
    private void m240a() {
        if (this.f450d != null) {
            Arrays.fill(this.f450d, 0.0f);
            Arrays.fill(this.f451e, 0.0f);
            Arrays.fill(this.f452f, 0.0f);
            Arrays.fill(this.f453g, 0.0f);
            Arrays.fill(this.f454h, 0);
            Arrays.fill(this.f455i, 0);
            Arrays.fill(this.f456j, 0);
            this.f457k = 0;
        }
    }

    /* renamed from: a */
    private void m241a(float f, float f2) {
        this.f466t = true;
        this.f464r.onViewReleased(this.f465s, f, f2);
        this.f466t = false;
        if (this.f447a == 1) {
            mo571a(0);
        }
    }

    /* renamed from: a */
    private void m242a(float f, float f2, int i) {
        m252c(i);
        float[] fArr = this.f450d;
        this.f452f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f451e;
        this.f453g[i] = f2;
        fArr2[i] = f2;
        this.f454h[i] = m237a((int) f, (int) f2);
        this.f457k |= 1 << i;
    }

    /* renamed from: a */
    private void m243a(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            this.f452f[pointerId] = x;
            this.f453g[pointerId] = y;
        }
    }

    /* renamed from: a */
    private boolean m244a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f454h[i] & i2) != i2 || (this.f462p & i2) == 0 || (this.f456j[i] & i2) == i2 || (this.f455i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f448b) && abs2 <= ((float) this.f448b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f464r.onEdgeLock(i2)) {
            return (this.f455i[i] & i2) == 0 && abs > ((float) this.f448b);
        }
        int[] iArr = this.f456j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    /* renamed from: a */
    private boolean m245a(int i, int i2, int i3, int i4) {
        int left = this.f465s.getLeft();
        int top = this.f465s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f463q.abortAnimation();
            mo571a(0);
            return false;
        }
        this.f463q.startScroll(left, top, i5, i6, m239a(this.f465s, i5, i6, i3, i4));
        mo571a(2);
        return true;
    }

    /* renamed from: a */
    private boolean m246a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f464r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.f464r.getViewVerticalDragRange(view) > 0;
        return (!z || !z2) ? z ? Math.abs(f) > ((float) this.f448b) : z2 && Math.abs(f2) > ((float) this.f448b) : (f * f) + (f2 * f2) > ((float) (this.f448b * this.f448b));
    }

    /* renamed from: b */
    private int m247b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    /* renamed from: b */
    private void m248b() {
        this.f458l.computeCurrentVelocity(1000, this.f459m);
        m241a(m236a(this.f458l.getXVelocity(this.f449c), this.f460n, this.f459m), m236a(this.f458l.getYVelocity(this.f449c), this.f460n, this.f459m));
    }

    /* renamed from: b */
    private void m249b(float f, float f2, int i) {
        int i2 = 1;
        if (!m244a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m244a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m244a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m244a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f455i;
            iArr[i] = iArr[i] | i2;
            this.f464r.onEdgeDragStarted(i2, i);
        }
    }

    /* renamed from: b */
    private void m250b(int i) {
        if (this.f450d != null) {
            this.f450d[i] = 0.0f;
            this.f451e[i] = 0.0f;
            this.f452f[i] = 0.0f;
            this.f453g[i] = 0.0f;
            this.f454h[i] = 0;
            this.f455i[i] = 0;
            this.f456j[i] = 0;
            this.f457k = ((1 << i) ^ -1) & this.f457k;
        }
    }

    /* renamed from: b */
    private void m251b(int i, int i2, int i3, int i4) {
        int left = this.f465s.getLeft();
        int top = this.f465s.getTop();
        if (i3 != 0) {
            i = this.f464r.clampViewPositionHorizontal(this.f465s, i, i3);
            this.f465s.offsetLeftAndRight(i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f464r.clampViewPositionVertical(this.f465s, i2, i4);
            this.f465s.offsetTopAndBottom(i2 - top);
        }
        int i6 = i2;
        if (i3 != 0 || i4 != 0) {
            this.f464r.onViewPositionChanged(this.f465s, i5, i6, i5 - left, i6 - top);
        }
    }

    /* renamed from: c */
    private void m252c(int i) {
        if (this.f450d == null || this.f450d.length <= i) {
            int i2 = i + 1;
            float[] fArr = new float[i2];
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (this.f450d != null) {
                System.arraycopy(this.f450d, 0, fArr, 0, this.f450d.length);
                System.arraycopy(this.f451e, 0, fArr2, 0, this.f451e.length);
                System.arraycopy(this.f452f, 0, fArr3, 0, this.f452f.length);
                System.arraycopy(this.f453g, 0, fArr4, 0, this.f453g.length);
                System.arraycopy(this.f454h, 0, iArr, 0, this.f454h.length);
                System.arraycopy(this.f455i, 0, iArr2, 0, this.f455i.length);
                System.arraycopy(this.f456j, 0, iArr3, 0, this.f456j.length);
            }
            this.f450d = fArr;
            this.f451e = fArr2;
            this.f452f = fArr3;
            this.f453g = fArr4;
            this.f454h = iArr;
            this.f455i = iArr2;
            this.f456j = iArr3;
        }
    }

    public static ViewDragHelper create(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper create = create(viewGroup, callback);
        create.f448b = (int) (((float) create.f448b) * (1.0f / f));
        return create;
    }

    public static ViewDragHelper create(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo571a(int i) {
        this.f467u.removeCallbacks(this.f468w);
        if (this.f447a != i) {
            this.f447a = i;
            this.f464r.onViewDragStateChanged(i);
            if (this.f447a == 0) {
                this.f465s = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo572a(View view, int i) {
        if (view == this.f465s && this.f449c == i) {
            return true;
        }
        if (view == null || !this.f464r.tryCaptureView(view, i)) {
            return false;
        }
        this.f449c = i;
        captureChildView(view, i);
        return true;
    }

    public void abort() {
        cancel();
        if (this.f447a == 2) {
            int currX = this.f463q.getCurrX();
            int currY = this.f463q.getCurrY();
            this.f463q.abortAnimation();
            int currX2 = this.f463q.getCurrX();
            int currY2 = this.f463q.getCurrY();
            this.f464r.onViewPositionChanged(this.f465s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        mo571a(0);
    }

    public void cancel() {
        this.f449c = -1;
        m240a();
        if (this.f458l != null) {
            this.f458l.recycle();
            this.f458l = null;
        }
    }

    public void captureChildView(View view, int i) {
        if (view.getParent() != this.f467u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f467u + ")");
        }
        this.f465s = view;
        this.f449c = i;
        this.f464r.onViewCaptured(view, i);
        mo571a(1);
    }

    public boolean checkTouchSlop(int i) {
        int length = this.f450d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (checkTouchSlop(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int i, int i2) {
        if (!isPointerDown(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f452f[i2] - this.f450d[i2];
        float f2 = this.f453g[i2] - this.f451e[i2];
        return (!z || !z2) ? z ? Math.abs(f) > ((float) this.f448b) : z2 && Math.abs(f2) > ((float) this.f448b) : (f * f) + (f2 * f2) > ((float) (this.f448b * this.f448b));
    }

    public boolean continueSettling(boolean z) {
        if (this.f447a == 2) {
            boolean computeScrollOffset = this.f463q.computeScrollOffset();
            int currX = this.f463q.getCurrX();
            int currY = this.f463q.getCurrY();
            int left = currX - this.f465s.getLeft();
            int top = currY - this.f465s.getTop();
            if (left != 0) {
                this.f465s.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f465s.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f464r.onViewPositionChanged(this.f465s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f463q.getFinalX() && currY == this.f463q.getFinalY()) {
                this.f463q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.f467u.post(this.f468w);
                } else {
                    mo571a(0);
                }
            }
        }
        return this.f447a == 2;
    }

    public View findTopChildUnder(int i, int i2) {
        for (int childCount = this.f467u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f467u.getChildAt(this.f464r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public void flingCapturedView(int i, int i2, int i3, int i4) {
        if (!this.f466t) {
            throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
        }
        this.f463q.fling(this.f465s.getLeft(), this.f465s.getTop(), (int) this.f458l.getXVelocity(this.f449c), (int) this.f458l.getYVelocity(this.f449c), i, i3, i2, i4);
        mo571a(2);
    }

    public int getActivePointerId() {
        return this.f449c;
    }

    public View getCapturedView() {
        return this.f465s;
    }

    public int getEdgeSize() {
        return this.f461o;
    }

    public float getMinVelocity() {
        return this.f460n;
    }

    public int getTouchSlop() {
        return this.f448b;
    }

    public int getViewDragState() {
        return this.f447a;
    }

    public boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.f465s, i, i2);
    }

    public boolean isEdgeTouched(int i) {
        int length = this.f454h.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (isEdgeTouched(i, i2)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEdgeTouched(int i, int i2) {
        return isPointerDown(i2) && (i & this.f454h[i2]) != 0;
    }

    public boolean isPointerDown(int i) {
        return ((1 << i) & this.f457k) != 0;
    }

    public boolean isViewUnder(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public void processTouchEvent(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.f458l == null) {
            this.f458l = VelocityTracker.obtain();
        }
        this.f458l.addMovement(motionEvent);
        int i2 = 0;
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View findTopChildUnder = findTopChildUnder((int) x, (int) y);
                m242a(x, y, pointerId);
                mo572a(findTopChildUnder, pointerId);
                int i3 = this.f454h[pointerId];
                if ((this.f462p & i3) != 0) {
                    this.f464r.onEdgeTouched(i3 & this.f462p, pointerId);
                    return;
                }
                return;
            case 1:
                if (this.f447a == 1) {
                    m248b();
                    break;
                }
                break;
            case 2:
                if (this.f447a == 1) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f449c);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    int i4 = (int) (x2 - this.f452f[this.f449c]);
                    int i5 = (int) (y2 - this.f453g[this.f449c]);
                    m251b(this.f465s.getLeft() + i4, this.f465s.getTop() + i5, i4, i5);
                } else {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        float x3 = motionEvent.getX(i2);
                        float y3 = motionEvent.getY(i2);
                        float f = x3 - this.f450d[pointerId2];
                        float f2 = y3 - this.f451e[pointerId2];
                        m249b(f, f2, pointerId2);
                        if (this.f447a != 1) {
                            View findTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                            if (!m246a(findTopChildUnder2, f, f2) || !mo572a(findTopChildUnder2, pointerId2)) {
                                i2++;
                            }
                        }
                    }
                }
                m243a(motionEvent);
                return;
            case 3:
                if (this.f447a == 1) {
                    m241a(0.0f, 0.0f);
                    break;
                }
                break;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                m242a(x4, y4, pointerId3);
                if (this.f447a == 0) {
                    mo572a(findTopChildUnder((int) x4, (int) y4), pointerId3);
                    int i6 = this.f454h[pointerId3];
                    if ((this.f462p & i6) != 0) {
                        this.f464r.onEdgeTouched(i6 & this.f462p, pointerId3);
                        return;
                    }
                    return;
                } else if (isCapturedViewUnder((int) x4, (int) y4)) {
                    mo572a(this.f465s, pointerId3);
                    return;
                } else {
                    return;
                }
            case 6:
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f447a == 1 && pointerId4 == this.f449c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 < pointerCount2) {
                            int pointerId5 = motionEvent.getPointerId(i2);
                            if (pointerId5 != this.f449c) {
                                if (findTopChildUnder((int) motionEvent.getX(i2), (int) motionEvent.getY(i2)) == this.f465s && mo572a(this.f465s, pointerId5)) {
                                    i = this.f449c;
                                }
                            }
                            i2++;
                        } else {
                            i = -1;
                        }
                    }
                    if (i == -1) {
                        m248b();
                    }
                }
                m250b(pointerId4);
                return;
            default:
                return;
        }
        cancel();
    }

    public void setEdgeTrackingEnabled(int i) {
        this.f462p = i;
    }

    public void setMinVelocity(float f) {
        this.f460n = f;
    }

    public boolean settleCapturedViewAt(int i, int i2) {
        if (this.f466t) {
            return m245a(i, i2, (int) this.f458l.getXVelocity(this.f449c), (int) this.f458l.getYVelocity(this.f449c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cc, code lost:
        if (r12 != r11) goto L_0x00d5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldInterceptTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r18.getActionMasked()
            int r3 = r18.getActionIndex()
            if (r2 != 0) goto L_0x0011
            r17.cancel()
        L_0x0011:
            android.view.VelocityTracker r4 = r0.f458l
            if (r4 != 0) goto L_0x001b
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r0.f458l = r4
        L_0x001b:
            android.view.VelocityTracker r4 = r0.f458l
            r4.addMovement(r1)
            r4 = 2
            r6 = 1
            switch(r2) {
                case 0: goto L_0x00f3;
                case 1: goto L_0x00ee;
                case 2: goto L_0x0067;
                case 3: goto L_0x00ee;
                case 4: goto L_0x0025;
                case 5: goto L_0x0030;
                case 6: goto L_0x0028;
                default: goto L_0x0025;
            }
        L_0x0025:
            r5 = 0
            goto L_0x0125
        L_0x0028:
            int r1 = r1.getPointerId(r3)
            r0.m250b(r1)
            goto L_0x0025
        L_0x0030:
            int r2 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r1 = r1.getY(r3)
            r0.m242a((float) r7, (float) r1, (int) r2)
            int r3 = r0.f447a
            if (r3 != 0) goto L_0x0055
            int[] r1 = r0.f454h
            r1 = r1[r2]
            int r3 = r0.f462p
            r3 = r3 & r1
            if (r3 == 0) goto L_0x0025
            android.widget.ViewDragHelper$Callback r3 = r0.f464r
            int r4 = r0.f462p
            r1 = r1 & r4
            r3.onEdgeTouched(r1, r2)
            goto L_0x0025
        L_0x0055:
            int r3 = r0.f447a
            if (r3 != r4) goto L_0x0025
            int r3 = (int) r7
            int r1 = (int) r1
            android.view.View r1 = r0.findTopChildUnder(r3, r1)
            android.view.View r3 = r0.f465s
            if (r1 != r3) goto L_0x0025
            r0.mo572a((android.view.View) r1, (int) r2)
            goto L_0x0025
        L_0x0067:
            float[] r2 = r0.f450d
            if (r2 == 0) goto L_0x0025
            float[] r2 = r0.f451e
            if (r2 != 0) goto L_0x0070
            goto L_0x0025
        L_0x0070:
            int r2 = r18.getPointerCount()
            r3 = 0
        L_0x0075:
            if (r3 >= r2) goto L_0x00e9
            int r4 = r1.getPointerId(r3)
            float r7 = r1.getX(r3)
            float r8 = r1.getY(r3)
            float[] r9 = r0.f450d
            r9 = r9[r4]
            float r9 = r7 - r9
            float[] r10 = r0.f451e
            r10 = r10[r4]
            float r10 = r8 - r10
            int r7 = (int) r7
            int r8 = (int) r8
            android.view.View r7 = r0.findTopChildUnder(r7, r8)
            if (r7 == 0) goto L_0x009f
            boolean r8 = r0.m246a((android.view.View) r7, (float) r9, (float) r10)
            if (r8 == 0) goto L_0x009f
            r8 = 1
            goto L_0x00a0
        L_0x009f:
            r8 = 0
        L_0x00a0:
            if (r8 == 0) goto L_0x00d5
            int r11 = r7.getLeft()
            int r12 = (int) r9
            int r13 = r11 + r12
            android.widget.ViewDragHelper$Callback r14 = r0.f464r
            int r12 = r14.clampViewPositionHorizontal(r7, r13, r12)
            int r13 = r7.getTop()
            int r14 = (int) r10
            int r15 = r13 + r14
            android.widget.ViewDragHelper$Callback r5 = r0.f464r
            int r5 = r5.clampViewPositionVertical(r7, r15, r14)
            android.widget.ViewDragHelper$Callback r14 = r0.f464r
            int r14 = r14.getViewHorizontalDragRange(r7)
            android.widget.ViewDragHelper$Callback r15 = r0.f464r
            int r15 = r15.getViewVerticalDragRange(r7)
            if (r14 == 0) goto L_0x00ce
            if (r14 <= 0) goto L_0x00d5
            if (r12 != r11) goto L_0x00d5
        L_0x00ce:
            if (r15 == 0) goto L_0x00e9
            if (r15 <= 0) goto L_0x00d5
            if (r5 != r13) goto L_0x00d5
            goto L_0x00e9
        L_0x00d5:
            r0.m249b((float) r9, (float) r10, (int) r4)
            int r5 = r0.f447a
            if (r5 != r6) goto L_0x00dd
            goto L_0x00e9
        L_0x00dd:
            if (r8 == 0) goto L_0x00e6
            boolean r4 = r0.mo572a((android.view.View) r7, (int) r4)
            if (r4 == 0) goto L_0x00e6
            goto L_0x00e9
        L_0x00e6:
            int r3 = r3 + 1
            goto L_0x0075
        L_0x00e9:
            r17.m243a((android.view.MotionEvent) r18)
            goto L_0x0025
        L_0x00ee:
            r17.cancel()
            goto L_0x0025
        L_0x00f3:
            float r2 = r18.getX()
            float r3 = r18.getY()
            r5 = 0
            int r1 = r1.getPointerId(r5)
            r0.m242a((float) r2, (float) r3, (int) r1)
            int r2 = (int) r2
            int r3 = (int) r3
            android.view.View r2 = r0.findTopChildUnder(r2, r3)
            android.view.View r3 = r0.f465s
            if (r2 != r3) goto L_0x0114
            int r3 = r0.f447a
            if (r3 != r4) goto L_0x0114
            r0.mo572a((android.view.View) r2, (int) r1)
        L_0x0114:
            int[] r2 = r0.f454h
            r2 = r2[r1]
            int r3 = r0.f462p
            r3 = r3 & r2
            if (r3 == 0) goto L_0x0125
            android.widget.ViewDragHelper$Callback r3 = r0.f464r
            int r4 = r0.f462p
            r2 = r2 & r4
            r3.onEdgeTouched(r2, r1)
        L_0x0125:
            int r1 = r0.f447a
            if (r1 != r6) goto L_0x012a
            r5 = 1
        L_0x012a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.widget.ViewDragHelper.shouldInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean smoothSlideViewTo(View view, int i, int i2) {
        this.f465s = view;
        this.f449c = -1;
        boolean a = m245a(i, i2, 0, 0);
        if (!a && this.f447a == 0 && this.f465s != null) {
            this.f465s = null;
        }
        return a;
    }
}
