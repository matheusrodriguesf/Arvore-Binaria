
/**
 *
 * @author matheus
 */
public class Arvore {

    No raiz;

    public Arvore() {

    }

    public void inserir(int dd) {
        No obj = new No();
        obj.dado = dd;

        if (raiz == null) {
            raiz = obj;
        } else {
            No atual = raiz;
            No parent;
            while (true) {
                parent = atual;
                if (dd < atual.dado) {
                    atual = atual.filhoEsquerda;
                    if (atual == null) {
                        parent.filhoEsquerda = obj;
                        return;
                    }//fim do if
                } else {
                    atual = atual.filhoDireita;
                    if (atual == null) {
                        parent.filhoDireita = obj;
                        return;
                    }//Fim do if
                }//Fim do else
            }
        }//fim do else

    }

    public No getSuccessor(No node) {
        No successorParent = node;
        No successor = node;
        No current = node.filhoDireita;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.filhoEsquerda;
        }
        if (successor != node.filhoDireita) {
            successorParent.filhoEsquerda = successor.filhoDireita;
            successor.filhoDireita = node.filhoDireita;
        }
        return successor;
    }

    public boolean remover(int dd) {
        No atual = raiz;
        No parent = raiz;
        boolean ffEsquerdo = true;
        while (atual.dado != dd) {
            parent = atual;
            if (dd < atual.dado) {
                ffEsquerdo = true;
                atual = atual.filhoEsquerda;
            } else {
                ffEsquerdo = false;
                atual = atual.filhoDireita;
            }
            if (atual == null) {
                return false;
            }
        }
        if (atual.filhoEsquerda == null && atual.filhoDireita == null) {
            if (atual == raiz) {
                raiz = null;
            } else if (ffEsquerdo) {
                parent.filhoEsquerda = null;
            } else {
                parent.filhoDireita = null;
            }
        } else if (atual.filhoDireita == null) {
            if (atual == raiz) {
                raiz = atual.filhoEsquerda;
            } else if (ffEsquerdo) {
                parent.filhoEsquerda = atual.filhoEsquerda;
            } else {
                parent.filhoDireita = atual.filhoEsquerda;
            }
        } else if (atual.filhoEsquerda == null) {
            if (atual == raiz) {
                raiz = atual.filhoDireita;
            } else if (ffEsquerdo) {
                parent.filhoEsquerda = atual.filhoDireita;
            } else {
                parent.filhoDireita = atual.filhoDireita;
            }
        } else {
            No successor = getSuccessor(atual);
            if (atual == raiz) {
                raiz = successor;
            } else if (ffEsquerdo) {
                parent.filhoEsquerda = successor;
            } else {
                parent.filhoDireita = successor;
            }
            successor.filhoEsquerda = atual.filhoEsquerda;
        }
        return true;
    }

    public void preOrder(No raizLocal) {
        if (raizLocal != null) {
            System.out.print(raizLocal.dado + " ");
            preOrder(raizLocal.filhoEsquerda);
            preOrder(raizLocal.filhoDireita);
        }
    }

    public void emOrder(No raizLocal) {
        if (raizLocal != null) {
            emOrder(raizLocal.filhoEsquerda);
            System.out.print(raizLocal.dado + " ");
            emOrder(raizLocal.filhoDireita);
        }

    }

    public void posOrder(No localRaiz) {
        if (localRaiz != null) {
            posOrder(localRaiz.filhoEsquerda);
            posOrder(localRaiz.filhoDireita);
            System.out.print(localRaiz.dado + " ");
        }

    }

    public No menor() {
        No atual, anterior = null;
        atual = raiz;
        while (atual != null) {
            anterior = atual;
            atual = atual.filhoEsquerda;
        }
        return anterior;
    }

    public No procurar(int dd) {
        No atual = raiz;
        while (atual.dado != dd) {
            if (dd < atual.dado) {
                atual = atual.filhoEsquerda;
            } else {
                atual = atual.filhoDireita;
            }
            if (atual == null) {
                return null;
            }
        }
        return atual;
    }

}
