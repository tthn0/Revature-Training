from pprint import pprint

from domain.book import Book
from repository.book_repository import BookRepository


class Repl:
    def __init__(self, book_repository: BookRepository) -> None:
        self.running = True
        self.book_repository = book_repository

    def run(self) -> None:
        print("REPL started.")

        while self.running:
            cmd = input(">>> ").strip()
            self.handle_command(cmd)

        print("REPL stopped.")

    def handle_command(self, cmd: str):
        if cmd == "exit":
            self.running = False
        elif cmd == "help":
            print("Available commands: exit, help, addBook, getAll")
        elif cmd == "addBook":
            self.add_book()
        elif cmd == "getAll":
            self.get_all_books()
        else:
            print(f"Unknown command: {cmd}")

    def add_book(self):
        try:
            title = input("Title: ")
            author = input("Author: ")
            book = Book(title, author)
            book_id = self.book_repository.add_book(book)
            print(f"Your book ID: {book_id}")
        except Exception as e:
            print(e)

    def get_all_books(self):
        try:
            books = self.book_repository.get_all_books()
            pprint(books)
        except FileNotFoundError:
            print("File not found.")
        except Exception as e:
            print(e)


if __name__ == "__main__":
    repl = Repl(BookRepository())
    repl.run()
